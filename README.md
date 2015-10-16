# Five Points
Welcome to the Five Points github repository! Five points is a class Computer Science project for the Cumberland County College Computer Science 3 course, Fall semester, 2015. We ask that you please do not submit any pull requests, as this is an educational project, and outside work defeats the purpose.

# The Project
## What is it?
The project itself is a computer simulation of the [Five Points](https://u.teknik.io/cTej7d.png) intersection in Philadelphia, PA. This particularly irritating intersection is the intersection of 5 major roads.
## How far along is it?
Currently, the project is at the 1.0 milestone. It models cars approaching a single traffic light from a one-direction, 3-lane street, and acting accordingly. 
## How does it work?
The simulation understands the concepts of Lanes, Cars, and Lights. Cars each have Routes which determine which Lanes they are placed in next.

The Lane itself
* Moves cars forward
* Sees a traffic light

Cars:
* Know their routes
* React according to their Lane's traffic light status

## What's with the Bluej / src / doc folder?
Computer Science 3 uses the BlueJ IDE for its coursework. However, for students who do not wish to use BlueJ, there is a portable src folder to integrate with their IDE of choice. Any changes done to src can be migrated to the bluej folder with update.sh.

The doc folder contains the generated javadoc (HTML) which is hosted on [Nate's Website]("http://www.natepi.com/five-points.html").

# Wiki
The wiki has been deprecated by automatic javadoc generation. However, you
can still access it  [here](https://github.com/CCCNJ-CS216/Five-Points/wiki)
