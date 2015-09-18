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
        console.log(NavigationBar);
    }

- NavigationBar.backgroundColorByHexString


StatusBar.backgroundColorByHexString
=================

Sets the background color of the statusbar by a hex string.

    StatusBar.backgroundColorByHexString("#C0C0C0");

CSS shorthand properties are also supported.

    StatusBar.backgroundColorByHexString("#333"); // => #333333
    StatusBar.backgroundColorByHexString("#FAB"); // => #FFAABB

Supported Platforms
-------------------

- Android 5+
