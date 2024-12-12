// See https://aka.ms/new-console-template for more information

int a = 3;
int b = 2;

void ScambiaValori(ref int a, ref int b)
{
    int temp = a;
    a = b;
    b = temp;

}

Console.WriteLine($"Il valore di a: {a} Il valore di b è {b}");
ScambiaValori(ref a, ref b);
Console.WriteLine($"Il valore di a: {a} Il valore di b è {b}");