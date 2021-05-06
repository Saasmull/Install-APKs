    //define the path
    path = "storage/emulated/0/folder/app.apk";
    
    //check SDK for both installations
    if(android.os.Build.VERSION.SDK_INT < 26){
      //install for Android 7.1/SDK 25 and <
      StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
      Intent intent = new Intent(Intent.ACTION_VIEW);
      intent.setDataAndType(Uri.fromFile(new java.io.File(path)),"application/vnd.android.package-archive");
      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      startActivity(intent);
    }else{
      //check install unknown sources
      if(!getPackageManager().canRequstPackageInstalls()){
        startActivity(new Intent(android.provider.Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, Uri.parse("package:COM.PACKAGE.NAME")));
      }else{
        //install for Android 8.0/SDK 26 and >
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        Intent intent = new Intent(Intent.ACTION_INSTALL_PACKAGE);
        intent.setDataAndType(Uri.fromFile(new java.io.File(path)));
        startActivity(intent);
      }
    }
