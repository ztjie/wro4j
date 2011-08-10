/*
 * YUI Compressor
 * Author: Julien Lecomte - http://www.julienlecomte.net/
 * Copyright (c) 2009 Yahoo! Inc.  All rights reserved.
 * The copyrights embodied in the content of this file are licensed
 * by Yahoo! Inc. under the BSD (revised) open source license.
 */

package com.yahoo.platform.yui.compressor;

import org.mozilla.javascript.Token;


/**
 * JavaScriptIdentifier represents a variable/function identifier.
 */
class JavaScriptIdentifier extends JavaScriptToken {

    private int refcount = 0;
    private String mungedValue;
    private final ScriptOrFnScope declaredScope;
    private boolean markedForMunging = true;

    JavaScriptIdentifier(final String value, final ScriptOrFnScope declaredScope) {
        super(Token.NAME, value);
        this.declaredScope = declaredScope;
    }

    ScriptOrFnScope getDeclaredScope() {
        return declaredScope;
    }

    void setMungedValue(final String value) {
        mungedValue = value;
    }

    String getMungedValue() {
        return mungedValue;
    }

    void preventMunging() {
        markedForMunging = false;
    }

    boolean isMarkedForMunging() {
        return markedForMunging;
    }

    void incrementRefcount() {
        refcount++;
    }

    int getRefcount() {
        return refcount;
    }
}
