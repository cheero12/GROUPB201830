
package clientserver;

    import java.lang.Thread;
    import java.net.*;
    import java.io.*;
    import java.util.*;
    import java.awt.*;

    public class Server_Second extends Frame  {

    //*****  single-thread server, with UI
    //            expected to be run on gamma.cs.unc.edu:8888

    MyFrame outerBox;

    TextField hostDisplay, portDisplay;
    TextArea logDisplay, msgDisplay;
    Panel topPanel;
    Panel middlePanel;
    Panel buttonPanel;
    Button listenButton, quitButton;

    public static final String DEFAULT_HOST = "gamma.cs.unc.edu";
    public static final int DEFAULT_PORT = 8888;
    String host;

      public Server_Second ()  {
        super ( "Server_Second " );
      }  // end Server_Second constructor

    // **************

      public void buildUI ()  {

      try {
        InetAddress here = InetAddress.getLocalHost ();
        host = here.toString();
      }
      catch (UnknownHostException e) { ;}
      hostDisplay = new TextField ( host, 30 );
      portDisplay = new TextField ( Integer.toString ( DEFAULT_PORT ), 4 );
      topPanel = new Panel ();
      topPanel.setLayout ( new BorderLayout () );
      topPanel.add ( "North", hostDisplay );
      topPanel.add ( "South", portDisplay );

      logDisplay = new TextArea ( 40, 10 );
      msgDisplay = new TextArea ( 40, 10 );
      middlePanel = new Panel ();
      middlePanel.setLayout ( new GridLayout ( 2, 1 ) );
      middlePanel.add ( logDisplay );
      middlePanel.add ( msgDisplay );

      listenButton = new Button ( "Listen" );
      quitButton = new Button ( "Quit" );
      buttonPanel = new Panel ( );
      buttonPanel.add ( listenButton );
      buttonPanel.add ( quitButton );

      outerBox = new MyFrame ( this, "Server_Second" );
      outerBox.add ( "North", topPanel );
      outerBox.add ( "Center", middlePanel );
      outerBox.add ( "South", buttonPanel );

      outerBox.resize ( 350, 400 );
      outerBox.show ();

      }  // end buildUI 

    // **************

      public void connectClient ( )  {

      ServerSocket listenSocket;
      Socket connection;
      OutputStream output;
      InputStream input;
      char c;
      String host;
      int port;

        if ( ! ( portDisplay.getText () ).equals ( "" ) ) port = Integer.parseInt ( portDisplay.getText () );
        else port = DEFAULT_PORT;

        try  {

          logDisplay.setText ( "Server started:  listening on port " + port + "\n" );
          listenSocket = new ServerSocket ( port );
          connection=  listenSocket.accept ();
          input = connection.getInputStream ();
          output = connection.getOutputStream ();

          logDisplay.appendText ( "Connection request received\n" );
          logDisplay.appendText ( "Message, below, received\n" );
          while ( (c = (char) input.read () ) != '#') 
          msgDisplay.appendText ( String.valueOf ( c ) ); 

          logDisplay.appendText ( "Message, below, sent to client \n" );
          String string = new String ( (msgDisplay.getText ()).concat("#") );
          for ( int i = 0; i < string.length(); i++ ) 
            output.write ( (int) string.charAt ( i ) );
          logDisplay.appendText ( "Message length = " + string.length () + "\n" );
          logDisplay.appendText ( "Closing socket\n" );
          connection.close ();

        }  // end try
        catch ( IOException except)  {
          except.printStackTrace ();
        }  // end catch

      }  // end connectClient 

    // **************


      public boolean action (Event event, Object arg) {

        if (event.target == listenButton )  {
           this.connectClient ();
          return true;
        }  // end listenButton 

        if (event.target == quitButton )  {
          hide ();
          dispose ();
          System.exit ( 0 );
          return true;
        }  // end quitButton 

        return false;

      }  // end action

      public boolean handleEvent ( Event event )  {

        if ( event.id == Event.WINDOW_ICONIFY )  {
          hide ();
          dispose ();
          System.exit ( 0 );
        }  // end if

        return super.handleEvent ( event );

      }  // end handleEvent 

    // **************

      public static void main ( String [ ] args )  {

        Server_Second server = new Server_Second ();
        server.buildUI ();
    //   server.connectClient ();

      }  // end main

    }  // end Server_Second 

    // ************************  MyFrame Class ************************

    class MyFrame extends Frame  {
      Frame source;

      MyFrame ( Frame a )  {
        super ( );
        source = a;
      }  // end constructor

      MyFrame ( Frame a, String title )  {
        super ( title );
        source = a;
      }  // end constructor

      public boolean action ( Event event, Object object )  {
        if ( source.action ( event, object ) ) return true;
        else return false;
      }  // end action

      public boolean handleEvent ( Event event )  {
        if ( source.handleEvent ( event ) ) return true;
        else return super.handleEvent ( event );
      }  // end handleEvent

    }  // end MyFrame

