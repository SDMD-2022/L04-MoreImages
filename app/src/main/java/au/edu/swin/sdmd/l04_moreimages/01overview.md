# Overview

This is an example of saving state using two approaches: saveInstanceState and view models.

There are two activities in this project; to switch from one to the other, edit line 12 in the Manifest file.

MainActivity uses a saveInstanceState approach, by saving data in a Bundle. A Bundle is an Android object that holds basic data types such as Strings and Ints. Bundles are serialised to disk and as such cannto hold very complex data types or large amounts of data.

The View Model approach is indeed overkill, but this is a very simple example to give you an idea of how it works. View models are kept in memory and are useful for keeping, for example, results of API calls when the device is rotated.

The ViewModel activity has been refactored quite significantly. You can see that the logic of showing the images has been moved to the view model object.

This project also contains a test to check that the image is indeed saving on rotation. When trying this with the view model activity, note the class on line 23 needs to be changed. Try removing the state saving or view model to break the test. Note this might result in some unexpected behaviour when the code is reinstated.