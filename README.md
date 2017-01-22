ChatAppsExample
===============

This sample aims to be as close to a real world example of a chat apps as possible. But many feature that I can't deliver, such as, there is no notification or integrated with WebSocket, etc, and cannot to send the message to server.

The app can show preview from when there is URL in the message, by using library from [UrlPreview](https://github.com/FreesoulApps/PreviewAndroid) that I've been customize, thanks for your libs "FreesoulApps"

The Source code that I attached in this repositroy was implement MVC. I use it because to make it easy if you trace the source code.

Introduction
------------

Steps for trying out this sample:

- Compile and install the mobile app onto your mobile device or emulator.
- Before you open the apps, make sure that you've been connected to Internet.

This sample aims to demonstrate a number of different Android APIs and concepts relating to Android App Chats that exist now
- Getting message data from Webservice.
- Display message data to chat UI, as same as Chat App that existing now.

Some of the UI widgets and design patterns used in the mobile app include:
- Use of Material theme including definition of primary and accent colors
- AppCompat usage for Material theme backward compatibility

Tools
-----
- Android Studio 2.2.3

Library
-------
- [UrlPreview](https://github.com/FreesoulApps/PreviewAndroid), I use it cause, when I try the other libs, I think this is better
- Retrofit 2, I use it cause I was familiar with that libs to get JSON data from Webservice
