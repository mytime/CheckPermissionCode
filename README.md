# CheckPermissionCode
代码中添加权限检查

1 自定义权限
  新建一个类：
    //1自定义一个权限
    // 需要注册到AndroidManifest
    public static final String PERMISSION_SAY_HELLO = "com.hello.checkpermissioncode.permission.SAY_HELLO";

    //Context: 配置访问全局的属性
    // 检查是否有权限

    public static void sayHello(Context context){

        //2 声明权限变量，执行这段程序是否拥有这个权限PERMISSION_SAY_HELLO
        int checkResult = context.checkCallingOrSelfPermission(PERMISSION_SAY_HELLO);

        //是否同意
        //PERMISSION_GRANTED:同意
        //PERMISSION_DENIED: 拒绝
        //3 检查权限，如果不能访问，抛出一个安全异常
        if(checkResult != PackageManager.PERMISSION_GRANTED){
            //4 无权限执行
            throw new SecurityException("执行sayHello方法需要com.hello.checkpermissioncode.permission.SAY_HELLO权限");

        }

        //5有权限执行，如果有访问权限，输出内容
        System.out.println("Hello world");

    };
2 Androidmanifest中注册权限，添加使用权限
    <!--定义一个权限，权限的名字是Hello类中自定义的权限-->
    <permission android:name="com.hello.checkpermissioncode.permission.SAY_HELLO"/>

    <!--添加一个使用权限-->
    <uses-permission android:name="com.hello.checkpermissioncode.permission.SAY_HELLO"/>

    
3 执行代码
    在MainActivity中执行代码
    Hello.sayHello(this);

