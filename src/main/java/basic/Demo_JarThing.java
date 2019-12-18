package basic;

public class Demo_JarThing {
    /**
     * JAR(Java archive file),是一种压缩文件,与ZIP文件兼容.区别在于jar文件中默认包含一个名为
     * META-INF/MAINFEST.MF 的清单文件.
     *
     */

    /**
     * 一:
     * javac -d targetPath javaFilePath 编译文件
     * java packageName.ClassName
     *
     * 二:
     * jar命令
     * 1. 创建jar文件
     * jar cf test.jar test
     * 当前目录下的test路劲下的全部内容生成一个test.jar文件
     * 2. 创建jar文件,并显示压缩文件: jar cvf test.jar test
     * 3. 不使用清单文件: jar cvfM test.jar test
     * 4. 自定义清单文件: jar cvfm test.jar textFilePath test
     * 自定义的请单位文件要以一个空行结尾
     *三:
     * 创建可执行的jar包
     *
     *
     */
}
