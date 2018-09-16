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
import static me.router.compiler.utils.Consts.PACKAGE_OF_GENERATE_FILE;
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

        logger.info(">>> ComponentRouterProcessor init. <<<");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
        if (annotations != null && annotations.size() != 0) {
            logger.error(RouterCompilerUtils.format(">>> Found %s, start... <<<", ComponentRouter.class.getSimpleName()));
            Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(ComponentRouter.class);
            try {
                if (elements != null && elements.size() != 0) {
                    logger.error(RouterCompilerUtils.format(">>> Resolve %s, size is %d <<<", ComponentRouter.class.getSimpleName(), elements.size()));
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
                logger.error(String.format(">>> %s annotations can only be used on classes. <<<", ComponentRouter.class.getSimpleName()));
            }


        }

        // Write root meta into disk.
//        String componentRoutersName = NAME_OF_ROOT + SEPARATOR + moduleName;
//        JavaFile.builder(PACKAGE_OF_GENERATE_FILE,
//                TypeSpec.classBuilder(componentRoutersName)
////                        .addJavadoc(WARNING_TIPS)
////                        .addSuperinterface(ClassName.get(elements.getTypeElement(ITROUTE_ROOT)))
//                        .addModifiers(PUBLIC)
////                        .addMethod(loadIntoMethodOfRootBuilder.build())
//                        .build()
//        ).build().writeTo(mFiler);
    }
}
