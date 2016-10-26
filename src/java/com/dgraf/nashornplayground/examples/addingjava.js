// Use Java.type to import a Java ArrayList into the script
arraylist = Java.type('java.util.ArrayList');

// and instantiate an arraylist
var list2 = new arraylist();

// call some methods, add data
list2.add("ddd2");
list2.add("aaa2");
list2.add("bbb1");
list2.add("aaa1");
list2.add("bbb3");
list2.add("ccc");
list2.add("bbb2");
list2.add("ddd1");

// now we can run some java lambda methods on our arraylist
// this will filter out all items starting with 'aaa'
// and sort them into alphabetical order

list2
    .stream()
    .filter(function(el) {
        return el.startsWith("aaa");
    })
    .sorted()
    .forEach(function(el) {
        print(el);
    });
    // aaa1, aaa2
