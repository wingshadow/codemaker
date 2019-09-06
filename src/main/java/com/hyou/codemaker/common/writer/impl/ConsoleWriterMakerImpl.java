package com.hyou.codemaker.common.writer.impl;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import com.hyou.codemaker.common.writer.WriterMaker;

/**
 * 将模板转换后生成的内容输出到控制台
 * @author Changshuo.Feng
 * @version 1.0.0 2014年8月3日 上午12:19:13
 */
public class ConsoleWriterMakerImpl implements WriterMaker {

    @Override
    public BufferedWriter getWriter() throws Exception {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }

}
