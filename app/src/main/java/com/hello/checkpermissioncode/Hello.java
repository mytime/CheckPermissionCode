package com.hello.checkpermissioncode;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by iwan on 16/1/8.
 */
public class Hello {

    //自定义一个权限
    // 需要注册到AndroidManifest
    public static final String PERMISSION_SAY_HELLO = "com.hello.checkpermissioncode.permission.SAY_HELLO";

    //Context: 配置访问全局的属性
    // 检查是否有权限

    public static void sayHello(Context context){

        //执行这段程序是否拥有这个权限PERMISSION_SAY_HELLO
        int checkResult = context.checkCallingOrSelfPermission(PERMISSION_SAY_HELLO);

        //是否同意
        //PERMISSION_GRANTED:同意
        //PERMISSION_DENIED: 拒绝
        //如果不能访问，抛出一个安全异常
        if(checkResult != PackageManager.PERMISSION_GRANTED){

            throw new SecurityException("执行sayHello方法需要com.hello.checkpermissioncode.permission.SAY_HELLO权限");

        }

        //如果有访问权限，输出内容
        System.out.println("Hello world");

    };
}
