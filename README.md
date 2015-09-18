# cordova-plugin-navigationbar

NavigationBar
======

> The `NavigationBar` object provides some functions to customize the Android Navigation Bar.


## Installation

This installation method requires cordova 5.0+

    cordova plugin add https://github.com/Tobiaswk/cordova-plugin-statusbar.git


Methods
-------
This plugin defines global `StatusBar` object.

Although in the global scope, it is not available until after the `deviceready` event.

    document.addEventListener("deviceready", onDeviceReady, false);
    function onDeviceReady() {
        console.log(StatusBar);
    }

- NavigationBar.backgroundColorByHexString


Supported Platforms
-------------------

- Android 4.0+
