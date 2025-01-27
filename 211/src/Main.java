import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Generate Generate = new Generate();
        String choice1,choice2,choice3,choice4="1",abc="1";
        double[] random = new double[21];
        int I=0,II=0,III=0,dirt=0;

        System.out.print("Do you want to test Fresh Water Quality?");
        System.out.print(" (Type y or n): ");
        Scanner scanner = new Scanner(System.in);
        choice1 = scanner.next();

        if (choice1.equals("y")){
        }else{
            Generate.Generation("Stopping the Program",333);
            return;
        }

        System.out.print("Type \"y\" to confirm to generate a random quality of fresh water: ");
        choice2 = scanner.next();

        if (choice2.equals("y")){
        }else{
            Generate.Generation("Stopping the Program",333);
            return;
        }

        System.out.println();
        Generate.Generation("Generating your random water",333);

        System.out.println();
        System.out.println("The Random Water Quality Data(Unit: mg/L): ");
        for (int i = 0; i < 21; i++) {
            double randomValue = (constant.D[i]) + (constant.E[i] - (constant.D[i])) * Math.random();
            DecimalFormat df = new DecimalFormat("0.00000");
            System.out.println(constant.F[i]+" Amount: "+df.format(randomValue));
            random[i] = randomValue;
            if(randomValue <= constant.A[i]){
                I++;
            }else if(randomValue <= constant.B[i]*1.2){
                II++;
            }else if(randomValue <= constant.C[i]){
                III++;
            }else {
                dirt++;
            }
        }
        System.out.println();

        int[] I1 = new int[I], II1 = new int[II], III1 = new int[III], dirt1 = new int[dirt];
        int a=0,b=0,c=0,d=0;

        for(int i = 0 ; i < 21 ; i++){
            if(random[i] <= constant.A[i]){
                I1[a]=i;
                a++;
            }else if(random[i] <= constant.B[i]*1.2){
                II1[b]=i;
                b++;
            }else if(random[i] <= constant.C[i]){
                III1[c]=i;
                c++;
            }else {
                dirt1[d]=i;
                d++;
            }
        }

        System.out.print("Type \"y\" to generate a water quality report of your water: ");
        choice3 = scanner.next();

        if (choice3.equals("y")){
        }else{
            Generate.Generation("Stopping the Program",333);
            return;
        }

        System.out.println();
        Generate.Generation("Generating your water Quality Report",333);

        System.out.println();
        System.out.println("Your Water Quality Report: ");
        if(I>=5 && dirt<=3 && I+II>=III+dirt+1) {
            System.out.println("GREAT!!! Your overall water quality is Class I. ");
            System.out.println("Which is the best of the three levels, you can be very confident of drinking the water!");
        }else if(dirt>5) {
            System.out.println("DANGERRRRR!!!!! YOUR WATER IS VERY DIRTY!!!");
            System.out.println("Your water doesn't meet any of the standard! You mustn't drink it!");
        }else if(I+II>III+dirt) {
            System.out.println("Good. Your overall water quality is Class II. ");
            System.out.println("Which is the second level of the water, you can drink the water after a few treatments.");
        }else if(I+II+III>dirt) {
            System.out.println("Be careful. Your overall water quality is Class III. ");
            System.out.println("Which is the last level of the water, you can drink the water after a very professional and detailed treatment.");
        }else{
            System.out.println("DANGERRRRR!!!!! YOUR WATER IS VERY DIRTY!!!");
            System.out.println("Your water doesn't meet any of the standard! You mustn't drink it!");
        }
        System.out.println();

        System.out.println("Of the 21 indicators of different substances tested, ");

        System.out.println(I + " met Class I water quality standards, ");

        System.out.println(II + " met Class II water quality standards, ");

        System.out.println(III + " met Class III water quality standards, ");
        System.out.print("which is ");
        for(int i=0;i<III;i++){
            System.out.print(constant.F[III1[i]]);
            System.out.print(", ");
        }
        System.out.println();

        System.out.println(dirt + " did not meet any water quality standards.  ");
        System.out.print("which is ");
        for(int i=0;i<dirt;i++){
            System.out.print(constant.F[dirt1[i]]);
            System.out.print(", ");
        }
        System.out.println();

        System.out.println();
        System.out.print("Type the elements you need to know how to handle (type n for no need): ");
        while(true) {
            choice4 = scanner.next();
            if(!choice4.equals(abc)){
                abc=choice4;
                Generate.Generation("Generating",180);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println();
                switch(choice4) {
                    case "Permanganate":
                        System.out.println("Please add some Sodium Thiosulfate.");
                        System.out.println("It reacts with permanganate to form non-toxic products and is widely used in water treatment.");
                        break;
                    case "Chemical Oxygen Demand":
                        System.out.println("Please decrease the organic and oxidizable inorganic matter that contributes to COD.");
                        System.out.println("You can use methods such as Chemical Precipitation or Physics Filtration");
                        break;
                    case "Five-day Biochemical Oxygen Demand":
                        System.out.println("Please use the method called Activated Sludge Process: ");
                        System.out.println("Which is commonly used aerobic treatment where microorganisms degrade organic pollutants, significantly lowering BOD levels.");
                        break;
                    case "Ammonia Nitrogen":
                        System.out.println("Please use nitrifying bacteria (e.g., Nitrosomonas and Nitrobacter).");
                        System.out.println("Ammonia Nitrogen will be biologically converted to nitrite (NO₂⁻) and then to nitrate (NO₃⁻)");
                        break;
                    case "Phosphorus":
                        System.out.println("Please add use the Alum Sedimentation Method. ");
                        System.out.println("Alum can precipitate phosphorus as aluminum phosphate, which can then be removed through sedimentation or filtration.");
                        break;
                    case "Nitrogen":
                        System.out.println("Please add chlorine in sufficient quantities");
                        System.out.println("It can oxidize ammonia into nitrogen gas.");
                        break;
                    case "Copper":
                        System.out.println("Please use the method called Ion Exchange Resins.");
                        System.out.println("Copper ions (Cu²⁺) can be exchanged with other ions (e.g. sodium or hydrogen) using ion exchange resins.");
                        break;
                    case "Zinc":
                        System.out.println("Please use the method called Ion Exchange Resins.");
                        System.out.println("Zinc ions (Zn²⁺) can be exchanged with other ions (e.g. sodium or hydrogen) using ion exchange resins.");
                        break;
                    case "Fluoride":
                        System.out.println("Please use the method called Reverse Osmosis. ");
                        System.out.println("This process effectively removes fluoride by forcing water through a semipermeable membrane, leaving fluoride and other contaminants behind.");
                        break;
                    case "Selenium":
                        System.out.println("Please use some activated alumina.");
                        System.out.println("This technique involves passing water through a medium that effectively binds selenium, allowing for its removal.");
                        break;
                    case "Arsenic":
                        System.out.println("Please use the method called Reverse Osmosis. ");
                        System.out.println("It is highly effective at removing arsenic and other contaminants.");
                        break;
                    case "Mercury":
                        System.out.println("Please add some Ferrous Sulfate.");
                        System.out.println("It can react with mercury to form insoluble compounds that can be removed through filtration.");
                        break;
                    case "Cadmium":
                        System.out.println("Please add some Sodium Sulfide.");
                        System.out.println("This can convert cadmium into insoluble forms that can be easily removed.");
                        break;
                    case "Chromium":
                        System.out.println("Please add some Sodium Bisulfite.");
                        System.out.println("It can reduce hexavalent chromium to trivalent chromium, which is less toxic and less soluble.");
                        break;
                    case "Lead":
                        System.out.println("Please add some Phosphates (like Sodium Tripolyphosphate). ");
                        System.out.println("They can be added to the water to form stable lead phosphate compounds that precipitate and can be removed through filtration.");
                        break;
                    case "Cyanide":
                        System.out.println("Please add some Chlorine or Chlorine Dioxide. ");
                        System.out.println("These agents can oxidize cyanide into less toxic compounds, such as cyanate, which can be further treated or removed.");
                        break;
                    case "Volatile Phenol":
                        System.out.println("Please use the method called Activated Carbon Adsorption. ");
                        System.out.println("It is highly effective at adsorbing volatile phenols due to its large surface area and porous structure. Phenols will adhere to the carbon.");
                        break;
                    case "Petroleum":
                        System.out.println("Please use the method called Bioremediation. ");
                        System.out.println("This method involves using microorganisms to degrade petroleum hydrocarbons into less harmful substances. Specific bacteria can metabolize hydrocarbons, making this an eco-friendly option.");
                        break;
                    case "Anionic Surfactants":
                        System.out.println("Please add coagulants like aluminum sulfate or iron salts. ");
                        System.out.println("It can help agglomerate surfactant molecules into larger particles (flocs), which can then be removed through sedimentation or filtration.");
                        break;
                    case "Sulfide":
                        System.out.println("Please use the method called Aeration. ");
                        System.out.println("It work by introducing air into the water can help oxidize sulfide naturally.");
                        break;
                    case "Fecal Coliform Bacteria":
                        System.out.println("Please use the method called Chlorination. ");
                        System.out.println("Adding chlorine is a common method to disinfect water, effectively killing fecal coliform bacteria.");
                        break;
                    case "n":
                        System.out.println("Thank you for your using this program! :D");
                        return;
                    default:
                        System.out.println("the element is no found. :(");
                        break;
                }
                System.out.println();
                System.out.print("Type the elements you need to know how to handle (type n for no need): ");
            }
        }
    }
}