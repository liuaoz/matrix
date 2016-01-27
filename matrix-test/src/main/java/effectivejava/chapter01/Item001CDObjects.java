package effectivejava.chapter01;

/**
 * Item 1:Consider static factory methods instead of constructors
 * 
 * static factory methods </br>
 * advantages: </br>
 * 1.One advantage of static factory methods is that, unlike constructors, they
 * have names. </br>
 * 2.A second advantage of static factory methods is that, unlike constructors,
 * they are not required to create a new object each time they’re invoked</br>
 * 3.A third advantage of static factory methods is that, unlike constructors,
 * they can return an object of any subtype of their return type. This gives you
 * great flexibility in choosing the class of the returned object. </br>
 * 4.A fourth advantage of static factory methods is that they reduce the
 * verbosity of creating parameterized type instances. disadvantages: </br>
 * 
 * disadvantage: </br>
 * 1.The main disadvantage of providing only static factory methods is that
 * classes without public or protected constructors cannot be subclassed.</br>
 * 2.A second disadvantage of static factory methods is that they are not
 * readily distinguishable from other static methods. </br>
 * 
 * @author matrix
 *
 * @date 2016年1月22日
 */
public class Item001CDObjects {

}
