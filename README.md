<a href="https://drive.google.com/file/d/1wgCLGjALgPBYUQK8uhXzW010Cp0ummn_/view?usp=share_link"><img src="https://github.com/shivenducs1136/buzzer/blob/main/Group%201%20(2).png" align="left" height="800" width="2000" ></a>
<p align="left">
	<h1 align="left">  JAM buzzer </h2>
	<h4 align="left"> Join Room, Create Room, Hit the buzzer! <h4>
</p>	


## Problem Statement. 
This application is specifically designed for the English/Hindi JAM event, which is hosted by Odyssey, the college's literary society. Participants are given a topic to speak on, and if they stumble, the person who buzzes the buzzer will speak in his place and the points will be added.

## Functionalities
#### Users can do the following:
- [ ] Room Admin can create rooms with Unique Room Codes. 
- [ ] Admin can share the Room Codes to their participants. 
- [ ] Admin can kick participant from Room. 
- [ ] Admin can enable the Buzzer for the participants. 
- [ ] Admin can Reset the Score.  
- [ ] Admin can view the Leaderboard.
- [ ] Participants can enter in the room by entering their names and room codes. 
- [ ] Participants can wait for the buzzer to be enabled. 
- [ ] Participants can Buzz the Buzzer whenever they needed. 
- [ ] Participants can leave the room anytime they want. 


## Instructions to run

* __Pre-requisites:__
	-  Android Studio v4.0
	-  A working Android physical device or emulator with USB debugging enabled

* __Directions to setup/install__
	- Clone this repository to your local storage using Git bash:
	```bash
	https://github.com/shivenducs1136/buzzer
	```
	- Open this project from Android Studio
	- Connect to an Android physical device or emulator
	- To install the app into your device, run the following using command line tools
	```bash
	gradlew installDebug
	```

* __Directions to execute__
	- To launch hands free, run the following using command line tools
	```bash
	adb shell monkey -p com.bitwisor.buzzer -c android.intent.category.LAUNCHER 1
	```

<br>

## Built with
- Kotlin
- XML
- Firebase

## Contributors
* [Shivendu](https://github.com/shivenducs1136)

<br>
<br>

<p align="center">
	Made during 🌙 by Shivendu Mishra
</p>
