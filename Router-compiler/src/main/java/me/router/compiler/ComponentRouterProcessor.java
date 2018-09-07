package me.router.compiler;

import com.google.auto.service.AutoService;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.JavaFileObject;

import me.router.annotation.ComponentRouter;
import me.router.compiler.utils.ProcessorLogger;

import static me.router.compiler.utils.Consts.ANNOTATION_COMPONENT_ROUTER;
import static me.router.compiler.utils.Consts.SEPARATOR;

/**
 *
 */
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes({ANNOTATION_COMPONENT_ROUTER})
public class ComponentRouterProcessor extends AbstractProcessor {

    private ProcessorLogger logger;

    private Types mTypeUtils;
    private Elements mElementUtils;
    private Filer mFiler;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);

        // Attempt to get user configuration [moduleName]
        Map<String, String> options = processingEnv.getOptions();
//        if (MapUtils.isNotEmpty(options)) {
//            String moduleName = options.get(KEY_MODULE_NAME);
//        }

        //初始化我们需要的基础工具
        mTypeUtils = processingEnv.getTypeUtils();
        mElementUtils = processingEnv.getElementUtils();
        mFiler = processingEnv.getFiler();

        logger = new ProcessorLogger(processingEnv.getMessager());

        logger.info(">>> RouteProcessor init. <<<");
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        //这里开始处理我们的注解解析了，以及生成Java文件
        if (set == null || set.isEmpty()) {
            logger.info(">>> set is null... <<<");
            return true;
        }

        logger.info(">>> Found field, start... <<<");

        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(ComponentRouter.class);

        if (elements == null || elements.isEmpty()) {
            logger.info(">>> elements is null... <<<");
            return true;
        }

        // 遍历所有被注解了@Factory的元素
        for (Element annotatedElement : elements) {

            // 检查被注解为@Factory的元素是否是一个类
            if (annotatedElement.getKind() != ElementKind.CLASS) {
                logger.error("Only classes can be annotated with "+ ComponentRouter.class.getSimpleName());
                return true; // 退出处理
            }

            analysisAnnotated(annotatedElement);
        }

        return true;
    }

    private void analysisAnnotated(Element classElement) {
        ComponentRouter annotation = classElement.getAnnotation(ComponentRouter.class);
        String name = "AAAAA";

//        TypeElement superClassName = mElementUtils.getTypeElement(name);
        String newClassName = name + SEPARATOR+"AAA";

        StringBuilder builder = new StringBuilder()
                .append("package com.zyao89.demoprocessor.auto;\n\n")
                .append("public class ")
                .append(newClassName)
                .append(" {\n\n") // open class
                .append("\tpublic String getMessage() {\n") // open method
                .append("\t\treturn \"");

        // this is appending to the return statement
        builder.append("Hello !!! Welcome ").append(name).append(" !\\n");


        builder.append("\";\n") // end return
                .append("\t}\n") // close method
                .append("}\n"); // close class


        try { // write the file
            JavaFileObject source = mFiler.createSourceFile("com.zyao89.demoprocessor.auto." + newClassName);
            Writer writer = source.openWriter();
            writer.write(builder.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // Note: calling e.printStackTrace() will print IO errors
            // that occur from the file already existing after its first run, this is normal
        }

        logger.info(">>> analysisAnnotated is finish... <<<");
    }
}
