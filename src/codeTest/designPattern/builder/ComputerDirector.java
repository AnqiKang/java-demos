package codeTest.designPattern.builder;

import codeTest.designPattern.builder.Computer;
import codeTest.designPattern.builder.ComputerBuilder;

/**
 * 负责构建
 * 将产品与创建过程解耦合， 使用相同的创建过程创建不同的产品
 * 控制产品生产过程
 * Director 是全程指导组装过程，具体的细节还是builder操作的
 */
public class ComputerDirector {
    public Computer create(ComputerBuilder builder) {
        builder.builderCpu();
        builder.builderDisk();
        builder.builderPower();
        builder.builderMemory();
        builder.builderMainboard();

        return builder.buildComputer();

    }

}
