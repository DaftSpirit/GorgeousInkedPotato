# GorgeousInkedPotato

  GorgeousInkedPotato (GIP) is an open-source web application used to LiveCode in a collaborative way.
  Just launch your browser edit your code and... TADAA !! sound ! (yay !)

# How to use GIP :

<b>1 - Server side application :</b>

Just compile the java sources and launch your server side app.
You can chose the port of listenning by adding a parameter when you launch your server.
It works both on Windows AND Linux !

<b> * Linux users : </b>
- javac -classpath . *.java
- jar cvfm launcher.jar META-INF/MANIFEST.MF *.class
- java -cp ./launcher.jar network.Server_Socket

<b> * Windows users : </b>
- javac -classpath . *.java
- jar cvfm launcher.jar META-INF/MANIFEST.MF *.class
- java -cp ./launcher.jar network.Server_Socket_Windows

<b>2 - Client side webApp :</b>

You may change 2 datas in js/firebase.js and in js/socket.js<br/>
* In js/firebase.js you may replace the firebase address by yours
* In js/socket.js you may replace the websocket address by yours.

Then just launch index.html in your favorite web browser (works only in the latest versions of Chrome, IE, Firefox and Safari)

# How to play with GIP

type sclang commands in the pad. To validate and send commands you have two ways :
* you can send one line by placing cursor on the line and pressing SHIFT+ENTER
* you can send a block of code by selecting the block and pressing CTRL+ENTER

Have fun using GorgeousInkedPotato ! =)

# How is GIP made :

GIP uses websockets to make the link between SCLang and the firepad collaborative code editor.
You simply enter SCLang lines in your pad and send them by pressing shift+enter
