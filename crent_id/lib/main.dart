import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: CrentCard()
  ));
}

class CrentCard extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.grey[900],
      appBar: AppBar(
        title: Text('Crent Card'),
        centerTitle: true,
        backgroundColor: Colors.grey[850],
        elevation: 0.0,
      ),
      body: Padding(
        padding: EdgeInsets.fromLTRB(30.0, 40.0, 30.0, 0.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            Center(
              child: CircleAvatar(
                backgroundImage: AssetImage('assets/my.jpg'),
                radius: 40.0,
              ),
            ),
            Divider(
            height: 60.0,
            color: Colors.grey[500],
            ),
            Text('Name',
            style: TextStyle(
              color: Colors.grey,
              letterSpacing: 2.0,
            ),
            ),
            SizedBox(height: 10.0),
            Text('Howdy Mowdy',
              style: TextStyle(
                color: Colors.amberAccent[200],
                letterSpacing: 2.0,
                fontSize: 28.0,
                fontWeight: FontWeight.bold
              ),
            ),
            SizedBox(height: 30.0),
            Text('Current Crent Power:',
              style: TextStyle(
                color: Colors.grey,
                letterSpacing: 2.0,
              ),
            ),
            SizedBox(height: 10.0),
            Text('693',
              style: TextStyle(
                  color: Colors.amberAccent[200],
                  letterSpacing: 2.0,
                  fontSize: 28.0,
                  fontWeight: FontWeight.bold
              ),
            ),
            SizedBox(height: 30.0,),
            Row(
              children: <Widget>[
                Icon(
                  Icons.email, color: Colors.amberAccent,
                ),
                SizedBox(width: 10.0,),
                Text('abcd@gmail.com',
                style: TextStyle(
                  color: Colors.grey[100],
                  fontSize: 10.0,
                  letterSpacing: 1.0
                ),)
              ],
            )
          ],
        ),
      ),
    );
  }
}

