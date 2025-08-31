
public class bit_manip_assignment {
    //link - https://chatgpt.com/c/68adfcfb-7b8c-8331-9392-bfd380635f3a

    //Q1 - 
    /*for the bitwise XOR operator ^, x ^ x is always 0 for any integer x.

    Why (bit manipulation view):

    XOR works bit-by-bit with the rule: 0^0=0, 1^1=0, 0^1=1, 1^0=1.

    Every bit of x XORed with the same bit of x gives 0. So the entire result is all zeros → 0.

    This holds for positive and negative integers (two’s complement doesn’t change the per-bit rule). 
    
    Tiny demo (Java/C++/Python all behave the same):

    int[] vals = {0, 1, 5, 123, -7, Integer.MIN_VALUE, Integer.MAX_VALUE};
    for (int x : vals) System.out.println(x ^ x); // prints 0 for all

    Handy related identities:

    x ^ 0 = x

    x ^ x = 0

    x ^ y ^ x = y (XOR cancels duplicates – useful for finding the unique element)
    */

    //Q2 - 
    /*We can swap two numbers a and b without using a third variable by exploiting the property of XOR:

    Key properties of XOR:

    x ^ x = 0

    x ^ 0 = x

    x ^ y ^ x = y (XOR cancels out duplicates)

    Swap algorithm (bit manipulation way)
    int a = 5, b = 7;

    a = a ^ b;  // Step 1
    b = a ^ b;  // Step 2
    a = a ^ b;  // Step 3

    System.out.println("a = " + a + ", b = " + b);

    Explanation

    Suppose initially:

    a = 5 (0101)

    b = 7 (0111)

    a = a ^ b
    → a = 0101 ^ 0111 = 0010 (a now holds XOR of original a and b)

    b = a ^ b
    → b = 0010 ^ 0111 = 0101 (b becomes original a)

    a = a ^ b
    → a = 0010 ^ 0101 = 0111 (a becomes original b)

    Now they are swapped:

    a = 7, b = 5. 
    Recall XOR properties:
    Self-canceling:

    𝑥⊕𝑥=0
    x⊕x=0

    Identity:

    𝑥⊕0=𝑥
    x⊕0=x

    Reversible:

    (𝑥⊕𝑦)⊕𝑦=𝑥
    (x⊕y)⊕y=x
    (because the second y cancels out the first)
    Step-by-step logic (assume original values: a = A, b = B)

    Step 1:
    a = a ^ b

    Now a = A ^ B

    b = B

    Step 2:
    b = a ^ b

    Substitute: b = (A ^ B) ^ B

    By property (reversible): (A ^ B) ^ B = A

    So now b = A

    Current state: a = A ^ B, b = A

    Step 3:
    a = a ^ b

    Substitute: a = (A ^ B) ^ A

    Again by reversible property: (A ^ B) ^ A = B

    So now a = B

    Final state: a = B, b = A
    */

    //Q3
    /*
     * Logic

    Adding 1 means flip all the trailing 1s to 0, and flip the first 0 (from the right) to 1.

    This is exactly what two’s complement properties give us with bit tricks.

    Method 1: Using -~x

    In many languages:

    int addOne(int x) {
        return -~x;
    }


    Why it works:

    ~x = bitwise NOT of x (flips all bits).

    -~x = negative of ~x.

    Algebraically, -~x = x + 1.

    Example:

    x = 5 (0101)

    ~x = 1010 (in 4 bits, but actually infinite bits in signed int)

    -~x = 6.
     */

     //Q4
     /*
      * 1. ASCII background

    Uppercase letters A–Z are 65–90 in ASCII.

    Lowercase letters a–z are 97–122 in ASCII.

    The difference between uppercase and lowercase is 32 (0b100000 in binary).

    Example:

    'A' = 0100 0001 (65)

    'a' = 0110 0001 (97)

    So converting uppercase → lowercase = set the 5th bit (bit value 32).

    2. Bit trick

    To convert uppercase → lowercase:

    char toLower(char c) {
        return c | 0b00100000;  // OR with 32
    }


    | (bitwise OR) with 32 forces that bit ON.

    If c is 'A', then 0100 0001 | 0010 0000 = 0110 0001 ('a').

    If c is already lowercase, nothing changes.

    3. Convert lowercase → uppercase

    To do the reverse (clear that bit):

    char toUpper(char c) {
        return c & 0b11011111;  // AND with ~32
    }


    This clears the 5th bit (subtracts 32 if it was set).

    4. Bonus trick

    Toggle case (uppercase ↔ lowercase):

    char toggleCase(char c) {
        return c ^ 0b00100000;  // XOR with 32
    }


    ✅ So the logic:

    Lowercase = Uppercase | 32

    Uppercase = Lowercase & ~32

    Toggle = Letter ^ 32
      */

    public static void main(String[] args) {
        
    }
}
