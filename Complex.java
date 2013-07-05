public class Complex
{
    
    private double a;
    private double b;
    
  //################################################################
	//################################################################ 
	
	public static void main(String[] args) {
    	
        ex1();
        ex2();
        ex3();
	}
    
	//################################################################
	//################################################################ 
	
    Complex()
    {
        a = 1.0;
        b = 1.0;
    }
    
    Complex(double rez,double imz)
    {
        a = rez;
        b = imz;
    }	
    //################################################################
	//################################################################ 
    public double r(){
        return Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
    }
    //################################################################
	//################################################################ 
    public double phi(){
            double phi = 0;
            if(a > 0){
                phi = Math.atan(b/a);
            }
            
            if(a == 0 && b > 0){
                phi = Math.PI / 2;
            }
            
            if(a == 0 && b < 0){
                phi = (Math.PI / 2) * -1;
            }
            
            if(a < 0 && b >= 0){
                phi = Math.atan(b/a) + Math.PI;
            }
            
            if(a < 0 && b < 0){
                phi = Math.atan(b/a) - Math.PI;
            }
            return phi;
    }
    

    //################################################################
	//################################################################ 

    public Complex add(Complex w){
        double a = this.a + w.getA();
        double b = this.b + w.getB();
        Complex sum = new Complex();
        sum.setAB(a,b);
        return sum;
    }

    //################################################################
	//################################################################ 

    public Complex subtract(Complex w){
        double a = this.a - w.getA();
        double b = this.b - w.getB();
        Complex dif = new Complex();
        dif.setAB(a,b);
        return dif;
    }
    
    //################################################################
	//################################################################ 

    public Complex multiply(Complex w){
        Complex product = new Complex();
        double a = this.a * w.getA() - this.b * w.getB();
        double b = this.a * w.getB() + this.b * w.getA();
        product.setAB(a,b);
        return product;
    }

    //################################################################
	//################################################################ 
    
    public Complex invers(){
        Complex z = new Complex();
        double r = 1 / this.r();
        double phi = this.phi() * -1;
        z.polar(r,phi);
        return z;
    }

    //################################################################
	//################################################################ 

    public Complex divide(Complex w){
        Complex quotient = new Complex();
        double den = Math.pow(w.getA(),2) + Math.pow(w.getB(),2);
        double a = (this.a * w.getA() + this.b * w.getB())/ den;
        double numB = (this.a * w.getB()*-1)+(this.b * w.getA());
        double b = numB/den;
        quotient.setAB(a,b);
        return quotient;
    }

    //################################################################
	//################################################################ 

    public Complex power(int n){
        Complex z = new Complex();
        double r = Math.pow(this.r(),n);
        double phi = this.phi() * n;

        z.polar(r,phi);
        return z;
    }
	
    public void polar(double r, double phi){
        a = Math.cos(phi) * r;
        b = Math.sin(phi) * r;
    }
	
    //################################################################
	//################################################################ 
	
    private static void ex1()
    {
        
        Complex z1 = new Complex(5,5);
        Complex z2 = new Complex(3,-4);
        Complex z3 = new Complex(4,3);
        Complex z4 = new Complex(20,0);
		
		System.out.println("");
		System.out.println("####################################################");
        System.out.println("Gegeben sind: z1= 5+5i, z2= 3-4i, z3= 4+3i, z4= 20");
        System.out.println("####################################################");
	    System.out.println("");
       
	    System.out.println("Berechne z1 + z3");
        System.out.println("");
        Complex a1 = z1.add(z3);
        print(a1);
        
		System.out.println("----------------------------------------------------");
        System.out.println("");
        System.out.println("Berechne z3 - z2");
        System.out.println("");
        Complex a2 = z3.subtract(z2);
        print(a2);
        
		System.out.println("----------------------------------------------------");
        System.out.println("");
        System.out.println("Berechne z4/z1");
        System.out.println("");
        Complex a3 = z4.divide(z1);
        print(a3);
        
		System.out.println("----------------------------------------------------");
        System.out.println("");
        System.out.println("Berechne z2 * z3");
        System.out.println("");
        Complex a4 = z2.multiply(z3);
        print(a4);
        
		System.out.println("----------------------------------------------------");
        System.out.println("");
        System.out.println("Berechne (z1/z2)+(z4/z3)");
        System.out.println("");
        Complex a5 = (z1.divide(z2)).add(z4.divide(z3));
        print(a5);
    }
    

    private static void ex2()
    {
		System.out.println("");
		System.out.println("####################################################");
        System.out.println("Tabelle Ergaenzen: a, b, r, phi");
		System.out.println("####################################################");      
	    System.out.println("");
	   
	    System.out.println("z1:");
		System.out.println("Gegeben ist r = 5, phi = - 2/3 pi");
        System.out.println("");
        System.out.println("a, b:");
        Complex z1 = new Complex();
        z1.polar(5,(-2*Math.PI/3));
        print(round(z1));
       
		System.out.println("----------------------------------------------------");
	    System.out.println("");
        System.out.println("z2:");
        System.out.println("Gegeben ist a = -16 * wurzel 2, b = -16 * wurzel 2");
        System.out.println("");
        Complex z2 = new Complex(-16*Math.sqrt(2),-16*Math.sqrt(2));
        double r2 = z2.r();
        double phi2 = z2.phi();
        System.out.println("r:");
		print(r2);
        System.out.println("phi:");
        print(round(phi2));
       
		System.out.println("----------------------------------------------------");
	    System.out.println("");
        System.out.println("z3:");
        System.out.println("Gegeben ist a = - 4, b = 0");
        System.out.println("");
        Complex z3 = new Complex(-4,0);
        double r3 = z3.r();
        double phi3 = z3.phi();
        System.out.println("r:");
        print(r3);
        System.out.println("phi:");
        print(round(phi3));
      
		System.out.println("----------------------------------------------------");
	    System.out.println("");
        System.out.println("z4:");
        System.out.println("Gegeben ist a = -2, b = 2 * wurzel 3");
        System.out.println("");
        Complex z4 = new Complex(-2,2*Math.sqrt(3));
        double r4 = z4.r();
        double phi4 = z4.phi();
        System.out.println("r:");
        print(round(r4));
        System.out.println("phi:");
        print(round(phi4));
        
		System.out.println("----------------------------------------------------");
        System.out.println("");
        System.out.println("Berechne z1 * z4");
        System.out.println("");
        Complex a5 = z1.multiply(z4);
        double r5 = a5.r();
        double phi5 = a5.phi();
        
        System.out.println("a, b:");
        print(round(a5));
        System.out.println("r:");
        print(r5);
        System.out.println("phi:");
        print(round(phi5));
        
		System.out.println("----------------------------------------------------");
        System.out.println("");
        System.out.println("Berechne 1/z2");
        System.out.println("");
        Complex numerator = new Complex(1,0);
        Complex a6 = numerator.divide(z2);
        double r6 = a6.r();
        double phi6 = a6.phi();
        
        System.out.println("a, b:");
        print(round(a6));
        System.out.println("r:");
        print(round(r6));
        System.out.println("phi:");
        print(round(phi6)); 

    }
    
	
    private static void ex3()
    {
        Complex z = new Complex(-1,1);

		System.out.println("");
		System.out.println("####################################################");
        System.out.println("Gegeben ist z = -1+i");
		System.out.println("####################################################");
        System.out.println("");
        
		System.out.println("Berechne z^6:");
        System.out.println("");
        Complex a1 = z.power(6);
        print(round(a1));
      
		System.out.println("----------------------------------------------------");
        System.out.println("");
        System.out.println("Berechne z^22:");
        System.out.println("");  
        Complex a2 = z.power(22);
        print(round(a2));
        System.out.println("");
   }
    
	//################################################################
	//################################################################ 
	
    private static void print(Complex result)
    {
		double b = result.getB();
		if (b<0){
        System.out.println("Ergebnis: " + result.getA() + " " + result.getB()+ "*i");
	}
	else {
        System.out.println("Ergebnis: " + result.getA() + " + " + result.getB()+ "*i");
		
	}
	}
    
    private static void print(double result)
    {
        System.out.println("Ergebnis: " + result);
    }
    
    
	//################################################################
	//################################################################ 
	
    private static Complex round(Complex w)
    {
        double a = w.getA();
        double b = w.getB();
        a = Math.round(a * 100) / 100.0;
        b = Math.round(b * 100) / 100.0;
        
        return new Complex(a,b);
    }

    private static double round(double w)
    {
        w = Math.round(w * 100) / 100.0;
        
        return w;
    }
    
	//################################################################
	//################################################################ 
	
    public double getA(){
        return a;
    }
     
    public double getB(){
        return b;
    }

    public void setAB(double rez, double imz){
        a = rez;
        b = imz;
    }
    
	//################################################################
	//################################################################ 
}
