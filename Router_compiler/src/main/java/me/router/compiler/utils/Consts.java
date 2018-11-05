package me.router.compiler.utils;

/**
 *
 */
public final class Consts {

    // Common
    public static final String PROJECT = "Router";
    public static final String ROUTER_MODULE_NAME = "ROUTER_MODULE_NAME";

    // Log
    public static final String PREFIX_OF_LOGGER = PROJECT + "::Compiler ";

    /*
     * #############################################################################################
     * 一些系统类的路径
     * #############################################################################################
     */

    public static final String ACTIVITY = "android.app.Activity";


    /*
     * #############################################################################################
     * 一些需要自动生成类的关键字及路径
     * #############################################################################################
     */

    public static final String PACKAGE_OF_GENERATE_FILE = "me.router.generate.routers";
    public static final String SEPARATOR = "$";
    public static final String CLASS_ROUTER_REGISTER = PROJECT + SEPARATOR + "Register";
    public static final String METHOD_REGISTER = "register";

    /*
     * #############################################################################################
     * 一些在框架已经存在的类的路径
     * #############################################################################################
     */

    public static final String ROOT_PACKAGE = "me.router";

    // Router-annotation
    public static final String ROUTER_ANNOTATION = ".annotation";
    public static final String ROUTER_ANNOTATION_COMPONENTINTERCEPTOR = ROOT_PACKAGE + ROUTER_ANNOTATION + ".ComponentInterceptor";
    public static final String ROUTER_ANNOTATION_COMPONENTROUTER = ROOT_PACKAGE + ROUTER_ANNOTATION + ".ComponentRouter";

    // Router-api
    public static final String ROUTER_API = ".api";
    public static final String ROUTER_API_ROUTERREGISTER = ROOT_PACKAGE + ROUTER_API + ".core.RouterRegister";
}