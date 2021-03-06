/*
################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Read the zproject/README.md for information about making permanent changes. #
################################################################################
*/
package org.zeromq.czmq;

import org.zeromq.tools.ZmqNativeLoader;

public class ZhttpClient implements AutoCloseable {
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
    Create a new http client
    */
    native static long __new (boolean verbose);
    public ZhttpClient (boolean verbose) {
        /*  TODO: if __new fails, self is null...            */
        self = __new (verbose);
    }
    public ZhttpClient (long pointer) {
        self = pointer;
    }
    /*
    Destroy an http client
    */
    native static void __destroy (long self);
    @Override
    public void close () {
        __destroy (self);
        self = 0;
    }
    /*
    Self test of this class.
    */
    native static void __test (boolean verbose);
    public static void test (boolean verbose) {
        __test (verbose);
    }
}
