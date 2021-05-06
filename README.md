# install-apk

>**Note: You need different Intents for different API Levels**

| Android-Version             | SDK/API | Intent                                                                                                            | Methode |
|:----------------------------|:--------|:------------------------------------------------------------------------------------------------------------------|:--------|
| 5.0(Lollipop) - 7.1(Nougat) | 21-25   | [`ACTION_VIEW`](https://developer.android.com/reference/android/content/Intent#ACTION_VIEW)                       | [Here](#for-api-21-to-25)
| 8.0(Oreo) - 9.0(Pie)        | 26-28   | [`ACTION_INSTALL_PACKAGE`](https://developer.android.com/reference/android/content/Intent#ACTION_INSTALL_PACKAGE) | [Here](#for-api-26-to-28)
| 10-11                       | 29-30   | [`ACTION_VIEW`](https://developer.android.com/reference/android/content/Intent#ACTION_VIEW)                       | [Here](#for-api-29-to-30)
    
# for API 21 to 25

```java
    //define the path
    path = "storage/emulated/0/folder/app.apk";
    
    //use StrictMode
    StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
    //create and define the Intent
    Intent intent = new Intent(Intent.ACTION_VIEW);
    //set the path and the type for the .apk-File
    intent.setDataAndType(Uri.fromFile(new java.io.File(path)),"application/vnd.android.package-archive");
    //setFlags to hide Error
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    //startActivity for this intent
    startActivity(intent);
```

# for API 26 to 28

# for API 29 to 30
