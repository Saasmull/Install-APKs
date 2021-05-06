# How to install .apk-Files with Java

Here you can learn how to install .apk-Files with Java on Android Devices

Content:
 1. [Manifest](#manifest)
 2. [Check unknown sources](#check-unknown-sources)
 3. [Starting the Installation](#starting-the-installation)
    + [...for API 21 to 25](#for-api-21-to-25)
    + [...for API 26 to 28](#for-api-26-to-28)
    + [...for API 29 to 30](#for-api-29-to-30)

# Manifest

For reading the storage you need: 
```XML
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
```
To install the .apk-File on API Level 26 and higher allow [`REQUEST_INSTALL_PACKAGES`](https://developer.android.com/reference/android/Manifest.permission#REQUEST_INSTALL_PACKAGES):
```XML
    <uses-permission android:name="android.permission.REQUEST_INSTALL_PACKAGES" />
```

# Check unknown sources

First we need to check that this App can install 3rd-Party-Apps without the PlayStore. For this we need to check the Settings for this App with:
```java
if(!getPackageManager().canRequestPackageInstalls())
```
If the option [`ACTION_MANAGE_UNKNOWN_APP_SOURCES`](https://developer.android.com/reference/android/provider/Settings#ACTION_MANAGE_UNKNOWN_APP_SOURCES) is disabled for this App than we can open the setting for this package for the user with this code:
```java
startActivity(new Intent(android.provider.Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, Uri.parse("package:COM.PACKAGE.NAME")));
```

# Starting the Installation

>**Note: You need different Intents for different API Levels**

| Android-Version             | SDK/API | Intent                                                                                                            | Methode |
|:----------------------------|:--------|:------------------------------------------------------------------------------------------------------------------|:--------|
| 5.0(Lollipop) - 7.1(Nougat) | 21-25   | [`ACTION_VIEW`](https://developer.android.com/reference/android/content/Intent#ACTION_VIEW)                       | [Here](#for-api-21-to-25)
| 8.0(Oreo) - 9.0(Pie)        | 26-28   | [`ACTION_INSTALL_PACKAGE`](https://developer.android.com/reference/android/content/Intent#ACTION_INSTALL_PACKAGE) | [Here](#for-api-26-to-28)
| 10-11                       | 29-30   | [`ACTION_VIEW`](https://developer.android.com/reference/android/content/Intent#ACTION_VIEW)                       | [Here](#for-api-29-to-30)
    
# for API 21 to 25

It uses the Intent [`ACTION_VIEW`](https://developer.android.com/reference/android/content/Intent#ACTION_VIEW).

First define the Path to the .apk-File:
```java
    //define the path
    path = "storage/emulated/0/folder/app.apk";
```
Then use the StrictMode:
```java
    //use the StrictMode
    StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
```
After that create and define the Intent with [`ACTION_VIEW`](https://developer.android.com/reference/android/content/Intent#ACTION_VIEW):
```java
    //create and define the Intent
    Intent intent = new Intent(Intent.ACTION_VIEW);
```
You must also define the File and the Type for the Intent. We use our defined variable [`path`](#for-api-21-to-25) as the data and the type [`application/vnd.android.package-archive`](https://mimetype.io/application/vnd.android.package-archive) like this:
```java
    //set the path and the type for the .apk-File
    intent.setDataAndType(Uri.fromFile(new java.io.File(path)),"application/vnd.android.package-archive");
 ```
 Then use [`FLAG_ACTIVITY_NEW_TASK`](https://developer.android.com/reference/android/content/Intent#FLAG_ACTIVITY_NEW_TASK) to define an atomic group of activities that the user can move to:
 ```java
    //setFlags to hide Error
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
```
And at the last you can start the installation with this code:
```java
    //startActivity for this intent
    startActivity(intent);
```

# for API 26 to 28

>**Note: This Methode works only from API 26 to 28 and is deprecated for API 29 and higher. You can read it [`here`](https://developer.android.com/reference/android/content/Intent#ACTION_INSTALL_PACKAGE).**

First define the Path to the .apk-File:
```java
    //define the path
    path = "storage/emulated/0/folder/app.apk";
```
Then use the StrictMode:
```java
    //use the StrictMode
    StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
```
After that create and define the Intent with [`ACTION_INSTALL_PACKAGE`](https://developer.android.com/reference/android/content/Intent#ACTION_INSTALL_PACKAGE):
```java
    //create and define the Intent
    Intent intent = new Intent(Intent.ACTION_INSTALL_PACKAGE);
```
You must also define the File for the Intent. We use our defined variable [`path`](#for-api-21-to-25) as the data like this:
```java
    //set the path and the type for the .apk-File
    intent.setDataAndType(Uri.fromFile(new java.io.File(path)));
```
 And at the last you can start the Installation with this code:
```java
    //startActivity for this intent
    startActivity(intent);
```

# for API 29 to 30

It's the [same](#for-api-21-to-25) Methode for API 21 to 25

