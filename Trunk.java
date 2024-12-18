package src;
//this goes into it's own file
public class Trunk
{
Trunk prev;
String str;

Trunk(Trunk prev, String str)
{
    this.prev = prev;
    this.str = str;
}
};
