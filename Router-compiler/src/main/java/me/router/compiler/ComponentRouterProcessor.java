package me.router.compiler;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
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
import me.router.compiler.utils.RouterCompilerUtils;

import static javax.lang.model.element.Modifier.PUBLIC;
import static me.router.compiler.utils.Consts.ANNOTATION_COMPONENT_ROUTER;
import static me.router.compiler.utils.Consts.ROUTER_MODULE_NAME;
import static me.router.compiler.utils.Consts.PACKAGE_OF_GENERATE_FILE;
import static me.router.compiler.utils.Consts.PROJECT;
import static me.router.compiler.utils.Consts.SEPARATOR;

/**
 *
 */
@AutoService(Processor.class)
@SupportedOptions({ROUTER_MODULE_NAME})
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes({ANNOTATION_COMPONENT_ROUTER})
public class ComponentRouterProcessor extends AbstractProcessor {

    private ProcessorLogger logger;

    // 被生成类所在 Module 的 Module name
    private String moduleName = null;

    // 将生成的文件写入磁盘
    private Filer filer;
    private Elements element;
    private Types type;


    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);

        filer = processingEnvironment.getFiler();
        element = processingEnvironment.getElementUtils();
        type = processingEnvironment.getTypeUtils();

        // Log
        logger = new ProcessorLogger(processingEnvironment.getMessager());

        // 获取 build.gradle 配置的 [moduleName]
        Map<String, String> options = processingEnvironment.getOptions();
        if (options != null && options.size() != 0) {
            moduleName = options.get(ROUTER_MODULE_NAME);
        }

        // 检查 Module 配置，你需要将你所有的 Android Module 配置 annotationProcessorOptions { arguments ... }
        if (moduleName != null && moduleName.length() != 0) {
            moduleName = moduleName.replaceAll("[^0-9a-zA-Z_]+", "");

            logger.info("The user has configuration the module name, it was [" + moduleName + "]");
        } else {
            logger.info("These no module name, at 'build.gradle', like :\n" +
                    "android {\n" +
                    "    defaultConfig {\n" +
                    "        ...\n" +
                    "        javaCompileOptions {\n" +
                    "            annotationProcessorOptions {\n" +
                    "                arguments = [ROUTER_MODULE_NAME: project.getName()]\n" +
                    "            }\n" +
                    "        }\n" +
                    "    }\n" +
                    "}\n");
            throw new RuntimeException("Router::Compiler >>> No module name, for more information, look at gradle log.");
        }


        logger.info(">>> ComponentRouterProcessor init. <<<");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
        if (annotations != null && annotations.size() != 0) {
            logger.info(RouterCompilerUtils.format(">>> Found %s, start... <<<", ComponentRouter.class.getSimpleName()));
            Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(ComponentRouter.class);
            try {
                if (elements != null && elements.size() != 0) {
                    logger.info(RouterCompilerUtils.format(">>> Resolve %s, size is %d <<<", ComponentRouter.class.getSimpleName(), elements.size()));
                    this.resolveComponentRouters(elements);
                }
            } catch (Exception e) {
                logger.error(e);
            }
        }

        return true;
    }

    /**
     * @param elements
     * @throws IOException
     */
    private void resolveComponentRouters(Set<? extends Element> elements) throws IOException {
        // 遍历所有被注解了 @ComponentRouter 的元素
        for (Element annotatedElement : elements) {
            // 检查被注解为 @ComponentRouter 的元素是否是类
            if (annotatedElement.getKind() == ElementKind.CLASS) {


            } else {
                logger.info(String.format(">>> %s annotations can only be used on classes. <<<", ComponentRouter.class.getSimpleName()));
            }


        }

        // Write root meta into disk.
        String componentRoutersName = PROJECT + SEPARATOR + moduleName;
        JavaFile.builder(PACKAGE_OF_GENERATE_FILE,
                TypeSpec.classBuilder(componentRoutersName)
//                        .addJavadoc(WARNING_TIPS)
//                        .addSuperinterface(ClassName.get(elements.getTypeElement(ITROUTE_ROOT)))
                        .addModifiers(PUBLIC)
//                        .addMethod(loadIntoMethodOfRootBuilder.build())
                        .build()
        ).build().writeTo(filer);
    }
}
