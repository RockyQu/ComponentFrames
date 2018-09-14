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
        if (set == null || set.isEmpty()) {
            return true;
        }

        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(ComponentRouter.class);

        if (elements == null || elements.isEmpty()) {
            return true;
        }

        // 遍历所有被注解了 @ComponentRouter 的元素
        for (Element annotatedElement : elements) {
            // 检查被注解为 @ComponentRouter 的元素是否是类
            if (annotatedElement.getKind() != ElementKind.CLASS) {
                logger.error(String.format("%s annotations can only be used on classes.", ComponentRouter.class.getSimpleName()));
                return true;
            }

        }

        return true;
    }
}
