# GorgeousInkedPotato

  GorgeousInkedPotato (GIP) is an open-source web application used to LiveCode in a collaborative way.
  Just launch your browser edit your code and... TADAA !! sound ! (yay !)

# How to use GIP :

1 - Server side application :

Just compile the java sources and launch your server side app.
You can chose the port of listenning by adding a parameter when you launch your server.
It works both on Windows AND Linux !

2 - Client side webApp :

You may change 2 datas in js/firebase.js and in js/socket.js.
In js/firebase.js you may replace the firebase address by yours
In js/socket.js you may replace the websocket address by yours.

Then just launch index.html in your favorite web browser (works only in the last versions of Chrome, IE, Firefox and Safari)

Have fun using GorgeousInkedPotato ! =)

# How is GIP made :

GIP uses websockets to make the link between SCLang and the firepad collaborative code editor.
You simply enter SCLang lines in your pad and send them by pressing shift+enter
