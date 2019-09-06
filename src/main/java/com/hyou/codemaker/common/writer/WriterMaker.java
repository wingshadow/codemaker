package com.hyou.codemaker.common.writer;

import java.io.BufferedWriter;

public interface WriterMaker {

    BufferedWriter getWriter() throws Exception;
    
}
