/*
################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Read the zproject/README.md for information about making permanent changes. #
################################################################################
*/
package org.zeromq.czmq;

import org.zeromq.tools.ZmqNativeLoader;

public class Zclock {
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
    Sleep for a number of milliseconds
    */
    native static void __sleep (int msecs);
    public static void sleep (int msecs) {
        __sleep (msecs);
    }
    /*
    Return current system clock as milliseconds. Note that this clock can
    jump backwards (if the system clock is changed) so is unsafe to use for
    timers and time offsets. Use zclock_mono for that instead.
    */
    native static long __time ();
    public static long time () {
        return __time ();
    }
    /*
    Return current monotonic clock in milliseconds. Use this when you compute
    time offsets. The monotonic clock is not affected by system changes and
    so will never be reset backwards, unlike a system clock.
    */
    native static long __mono ();
    public static long mono () {
        return __mono ();
    }
    /*
    Return current monotonic clock in microseconds. Use this when you compute
    time offsets. The monotonic clock is not affected by system changes and
    so will never be reset backwards, unlike a system clock.
    */
    native static long __usecs ();
    public static long usecs () {
        return __usecs ();
    }
    /*
    Return formatted date/time as fresh string. Free using zstr_free().
    */
    native static String __timestr ();
    public static String timestr () {
        return __timestr ();
    }
    /*
    Self test of this class.
    */
    native static void __test (boolean verbose);
    public static void test (boolean verbose) {
        __test (verbose);
    }
}
