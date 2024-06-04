import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Home()
  ));


}

class Home extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('FlutterFirst'),
        centerTitle: true ,
        backgroundColor: Colors.red[600],
      ),
      body:
      Row(
       children: <Widget>[
         Expanded(
             flex: 4,
             child: Image.asset('assets/camaro.jpg')),
        Expanded(
          flex: 3,
          child: Container(
             padding: EdgeInsets.symmetric(horizontal: 20.0, vertical: 30.0 ),
             color: Colors.yellowAccent[400],
             child: Text('hello'),
           ),
        ),
         Expanded(
           flex: 5,
           child: Container(
             padding: EdgeInsets.symmetric(horizontal: 20.0, vertical: 30.0 ),
             color: Colors.blueAccent[400],
             child: Text('hello'),
           ),
         ),
         Expanded(
           flex: 3,
        child: Container(
        padding: EdgeInsets.symmetric(horizontal: 20.0, vertical: 30.0 ),
        color: Colors.redAccent[400],
        child: Text('hello'),
      ),
         ),
       ],
      ),
//          Text('Howdy Mowdy'),
//          RaisedButton(
//            onPressed: () {
//              print('CLICK CLICK');
//            }, child: Text('LIkE KAR'),
//          ),
//      Container(
//        padding: EdgeInsets.symmetric(horizontal: 20.0, vertical: 30.0 ),
//        color: Colors.grey[400],
//        child: Text('hello'),
//      ),
//        ],
//      ),
//      Container(
//        padding: EdgeInsets.symmetric(horizontal: 20.0, vertical: 30.0 ),
//        margin: EdgeInsets.all(50.0),
//        color: Colors.grey[400],
//        child: Text('hello'),
//      ),

//      Center (
//        child: IconButton(icon: Icon(Icons.alternate_email), onPressed: () {
//          print('CLicked me');
//        }, color: Colors.amber, iconSize: 100.0,),
//
////        RaisedButton.icon(onPressed: () {}
////        , icon: Icon(Icons.mail), label: Text('Mail Me'), color: Colors.amberAccent,)
//
//
////        Text('Howdy Mowdy',
////          style: TextStyle(
////            fontSize: 20.0,
////            fontWeight: FontWeight.bold,
////            letterSpacing: 2.0,
////            color: Colors.grey[600],
////            fontFamily: 'IndieFlower',
////          ),
//
//      ),
      floatingActionButton: FloatingActionButton(
        onPressed: (){} ,
        child: Text('click'),
        backgroundColor: Colors.red[600],
      ),
    );
  }
}
