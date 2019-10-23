/*
################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Read the zproject/README.md for information about making permanent changes. #
################################################################################
*/
package org.zeromq.czmq;

import org.zeromq.tools.ZmqNativeLoader;

public class Zmsg implements AutoCloseable {
    static {
        ZmqNativeLoader.loadLibrary("zmq", true);
        ZmqNativeLoader.loadLibrary("uuid", true);
        ZmqNativeLoader.loadLibrary("libsystemd", true);
        ZmqNativeLoader.loadLibrary("lz4", true);
        ZmqNativeLoader.loadLibrary("curl", true);
        ZmqNativeLoader.loadLibrary("nss", true);
        ZmqNativeLoader.loadLibrary("microhttpd", true);
        ZmqNativeLoader.loadLibrary("czmq", true);
        ZmqNativeLoader.loadLibrary("czmqjni", false);
    }
    public long self;
    /*
    Create a new empty message object
    */
    native static long __new ();
    public Zmsg () {
        /*  TODO: if __new fails, self is null...            */
        self = __new ();
    }
    public Zmsg (long pointer) {
        self = pointer;
    }
    /*
    Receive message from socket, returns zmsg_t object or NULL if the recv
    was interrupted. Does a blocking recv. If you want to not block then use
    the zloop class or zmsg_recv_nowait or zmq_poll to check for socket input
    before receiving.
    */
    native static long __recv (long source);
    public static Zmsg recv (long source) {
        return new Zmsg (__recv (source));
    }
    /*
    Decodes a serialized message frame created by zmsg_encode () and returns
    a new zmsg_t object. Returns NULL if the frame was badly formatted or
    there was insufficient memory to work.
    */
    native static long __decode (long frame);
    public static Zmsg decode (Zframe frame) {
        return new Zmsg (__decode (frame.self));
    }
    /*
    Generate a signal message encoding the given status. A signal is a short
    message carrying a 1-byte success/failure code (by convention, 0 means
    OK). Signals are encoded to be distinguishable from "normal" messages.
    */
    native static long __newSignal (byte status);
    public static Zmsg newSignal (byte status) {
        return new Zmsg (__newSignal (status));
    }
    /*
    Destroy a message object and all frames it contains
    */
    native static void __destroy (long self);
    @Override
    public void close () {
        __destroy (self);
        self = 0;
    }
    /*
    Send message to destination socket, and destroy the message after sending
    it successfully. If the message has no frames, sends nothing but destroys
    the message anyhow. Nullifies the caller's reference to the message (as
    it is a destructor).
    */
    native static long __send (long self, long dest);
    public void send (long dest) {
        self = __send (self, dest);
    }
    /*
    Send message to destination socket as part of a multipart sequence, and
    destroy the message after sending it successfully. Note that after a
    zmsg_sendm, you must call zmsg_send or another method that sends a final
    message part. If the message has no frames, sends nothing but destroys
    the message anyhow. Nullifies the caller's reference to the message (as
    it is a destructor).
    */
    native static long __sendm (long self, long dest);
    public void sendm (long dest) {
        self = __sendm (self, dest);
    }
    /*
    Return size of message, i.e. number of frames (0 or more).
    */
    native static long __size (long self);
    public long size () {
        return __size (self);
    }
    /*
    Return total size of all frames in message.
    */
    native static long __contentSize (long self);
    public long contentSize () {
        return __contentSize (self);
    }
    /*
    Return message routing ID, if the message came from a ZMQ_SERVER socket.
    Else returns zero.
    */
    native static int __routingId (long self);
    public int routingId () {
        return __routingId (self);
    }
    /*
    Set routing ID on message. This is used if/when the message is sent to a
    ZMQ_SERVER socket.
    */
    native static void __setRoutingId (long self, int routingId);
    public void setRoutingId (int routingId) {
        __setRoutingId (self, routingId);
    }
    /*
    Push frame to the front of the message, i.e. before all other frames.
    Message takes ownership of frame, will destroy it when message is sent.
    Returns 0 on success, -1 on error. Deprecates zmsg_push, which did not
    nullify the caller's frame reference.
    */
    native static int __prepend (long self, long frameP);
    public int prepend (Zframe frameP) {
        return __prepend (self, frameP.self);
    }
    /*
    Add frame to the end of the message, i.e. after all other frames.
    Message takes ownership of frame, will destroy it when message is sent.
    Returns 0 on success. Deprecates zmsg_add, which did not nullify the
    caller's frame reference.
    */
    native static int __append (long self, long frameP);
    public int append (Zframe frameP) {
        return __append (self, frameP.self);
    }
    /*
    Remove first frame from message, if any. Returns frame, or NULL.
    */
    native static long __pop (long self);
    public Zframe pop () {
        return new Zframe (__pop (self));
    }
    /*
    Push block of memory to front of message, as a new frame.
    Returns 0 on success, -1 on error.
    */
    native static int __pushmem (long self, byte [] data, long size);
    public int pushmem (byte [] data, long size) {
        return __pushmem (self, data, size);
    }
    /*
    Add block of memory to the end of the message, as a new frame.
    Returns 0 on success, -1 on error.
    */
    native static int __addmem (long self, byte [] data, long size);
    public int addmem (byte [] data, long size) {
        return __addmem (self, data, size);
    }
    /*
    Push string as new frame to front of message.
    Returns 0 on success, -1 on error.
    */
    native static int __pushstr (long self, String string);
    public int pushstr (String string) {
        return __pushstr (self, string);
    }
    /*
    Push string as new frame to end of message.
    Returns 0 on success, -1 on error.
    */
    native static int __addstr (long self, String string);
    public int addstr (String string) {
        return __addstr (self, string);
    }
    /*
    Push formatted string as new frame to front of message.
    Returns 0 on success, -1 on error.
    */
    native static int __pushstrf (long self, String format);
    public int pushstrf (String format) {
        return __pushstrf (self, format);
    }
    /*
    Push formatted string as new frame to end of message.
    Returns 0 on success, -1 on error.
    */
    native static int __addstrf (long self, String format);
    public int addstrf (String format) {
        return __addstrf (self, format);
    }
    /*
    Pop frame off front of message, return as fresh string. If there were
    no more frames in the message, returns NULL.
    */
    native static String __popstr (long self);
    public String popstr () {
        return __popstr (self);
    }
    /*
    Push encoded message as a new frame. Message takes ownership of
    submessage, so the original is destroyed in this call. Returns 0 on
    success, -1 on error.
    */
    native static int __addmsg (long self, long msgP);
    public int addmsg (Zmsg msgP) {
        return __addmsg (self, msgP.self);
    }
    /*
    Remove first submessage from message, if any. Returns zmsg_t, or NULL if
    decoding was not successful.
    */
    native static long __popmsg (long self);
    public Zmsg popmsg () {
        return new Zmsg (__popmsg (self));
    }
    /*
    Remove specified frame from list, if present. Does not destroy frame.
    */
    native static void __remove (long self, long frame);
    public void remove (Zframe frame) {
        __remove (self, frame.self);
    }
    /*
    Set cursor to first frame in message. Returns frame, or NULL, if the
    message is empty. Use this to navigate the frames as a list.
    */
    native static long __first (long self);
    public Zframe first () {
        return new Zframe (__first (self));
    }
    /*
    Return the next frame. If there are no more frames, returns NULL. To move
    to the first frame call zmsg_first(). Advances the cursor.
    */
    native static long __next (long self);
    public Zframe next () {
        return new Zframe (__next (self));
    }
    /*
    Return the last frame. If there are no frames, returns NULL.
    */
    native static long __last (long self);
    public Zframe last () {
        return new Zframe (__last (self));
    }
    /*
    Serialize multipart message to a single message frame. Use this method
    to send structured messages across transports that do not support
    multipart data. Allocates and returns a new frame containing the
    serialized message. To decode a serialized message frame, use
    zmsg_decode ().
    */
    native static long __encode (long self);
    public Zframe encode () {
        return new Zframe (__encode (self));
    }
    /*
    Create copy of message, as new message object. Returns a fresh zmsg_t
    object. If message is null, or memory was exhausted, returns null.
    */
    native static long __dup (long self);
    public Zmsg dup () {
        return new Zmsg (__dup (self));
    }
    /*
    Send message to zsys log sink (may be stdout, or system facility as
    configured by zsys_set_logstream).
    */
    native static void __print (long self);
    public void print () {
        __print (self);
    }
    /*
    Return true if the two messages have the same number of frames and each
    frame in the first message is identical to the corresponding frame in the
    other message. As with zframe_eq, return false if either message is NULL.
    */
    native static boolean __eq (long self, long other);
    public boolean eq (Zmsg other) {
        return __eq (self, other.self);
    }
    /*
    Return signal value, 0 or greater, if message is a signal, -1 if not.
    */
    native static int __signal (long self);
    public int signal () {
        return __signal (self);
    }
    /*
    Probe the supplied object, and report if it looks like a zmsg_t.
    */
    native static boolean __is (long self);
    public static boolean is (long self) {
        return __is (self);
    }
    /*
    Self test of this class.
    */
    native static void __test (boolean verbose);
    public static void test (boolean verbose) {
        __test (verbose);
    }
}
