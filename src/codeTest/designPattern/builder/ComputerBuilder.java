package codeTest.designPattern.builder;

import codeTest.designPattern.builder.Computer;

/**
 * Builder的公共方法
 */
public interface ComputerBuilder {
    // 细节方法
    void builderCpu();
    void builderMainboard();
    void builderDisk();
    void builderPower();
    void builderMemory();

    // 产生最后的产品
    Computer buildComputer();
}
