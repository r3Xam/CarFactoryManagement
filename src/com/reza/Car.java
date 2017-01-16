package com.reza;

import java.util.*;

/**
 * Created by MohammadReza on 2017-01-09.
 */
public class Car{

    private static int benzNumber = 0;
    private static int bmwNumber = 0;
    private static int peugeotNumber = 0;
    private static int samandNumber = 0;
    private static int prideNumber = 0;
    private static int uiNumber,carFindNumber,pelaakError = 0, languageNumer;
    private static long newLicensePlateNumber;

    private Car[] benzs = new Car[100];
    private Car[] bmws = new Car[100];
    private Car[] peugeots = new Car[100];
    private Car[] samands = new Car[100];
    private Car[] prides = new Car[100];

    private long licensePlateNumber;
    private long chassisNumber;
    private int modelYear;
    private int topSpeed;
    private int fuelTankCapacity;
    private String color;

    public Car() {
        this.licensePlateNumber = 0;
        this.chassisNumber = 0;
        this.modelYear = 0;
        this.topSpeed = 0;
        this.fuelTankCapacity = 0;
        this.color = "unKnown";
    }

    public void startProgram() {
        this.uiMain();
    }

    public void languageSelection(){
        languageNumer =0;
        System.out.println("زبان مورد نظر خود را انتخاب نمایید:" +
                "\n" + "Select your language:" +
                "\n" + "۱) فارسی" +
                "\n" + "2) English");
        Scanner inLang = new Scanner(System.in);
        int l = inLang.nextInt();
        if (l == 1)
            languageNumer = 1;
        else if (l == 2)
            languageNumer = 2;
        else {
            System.out.println("ورودی غیر مجاز" +
                    "\n" + "Invalid Entry" +
                    "\n");
            languageSelection();
        }

    }

    private void uiMain() {
        declareThemAll();
        do {
            languageSelection();
        }while (languageNumer < 1 || languageNumer > 2);

        do {
            if(languageNumer == 1)
                System.out.println("گزینه مورد نظر خود را انتخاب نمایید." +
                    "\n" + "۱) مشاهده ی خودروهای موجود." +
                    "\n" + "۲)ایحاد خودرو جدید" +
                    "\n" + "۳) دریافت اطلاعات خودرو از طریق پلاک" +
                    "\n" + "9) Language selection screen." +
                    "\n"+ "۰) خروج");
            else if(languageNumer == 2)
                System.out.println("Select your desired operation." +
                        "\n" + "1) Show all available cars." +
                        "\n" + "2) Create a new car" +
                        "\n" + "3) Get a car's information by its Licence Plate Number." +
                        "\n" + "۹) منوی انتخاب زبان." +
                        "\n" + "0) Quit");
            Scanner input = new Scanner(System.in);
            uiNumber = input.nextInt();
            switch (uiNumber) {
                case 1:
                    if(benzNumber + bmwNumber + peugeotNumber + prideNumber + samandNumber == 0) {
                        if (languageNumer == 1)
                            System.out.println("هیچ خودرویی ثبت نشده است!" +
                                    "\n" + "برای ایجاد خودرو از گزینه ی ۲ استفاده کنید.");
                        else if (languageNumer == 2)
                            System.out.println("There is no car set yet." +
                                    "\n" + "To create a new car use number 2.");
                    }
                    else
                        showCars();
                    break;
                case 2:
                    if(languageNumer == 1)
                        System.out.println("نوع خودرو را مشخص نمایید:" +
                            "\n" + "۱) مرسدس بنز" +
                            "\n" + "۲) بی ام دبلیو" +
                            "\n" + "۳) پژو" +
                            "\n" + "۴) سمند" +
                            "\n" + "۵) پراید" );
                    else if(languageNumer == 2)
                        System.out.println("Choose the brand of car." +
                                "\n" + "1) Mercedes-Benz" +
                                "\n" + "2) BMW" +
                                "\n" + "3) Peugeot" +
                                "\n" + "4) Samand" +
                                "\n" + "5) Pride" );
                    Scanner input1 = new Scanner(System.in);
                    switch (input1.nextInt()) {
                        case 1:
                            createNewCar(benzs, Car.benzNumber);
                            benzNumber++;
                            break;
                        case 2:
                            createNewCar(bmws, Car.bmwNumber);
                            bmwNumber++;
                            break;
                        case 3:
                            createNewCar(peugeots, Car.peugeotNumber);
                            peugeotNumber++;
                            break;
                        case 4:
                            createNewCar(samands, Car.samandNumber);
                            samandNumber++;
                            break;
                        case 5:
                            createNewCar(prides, Car.prideNumber);
                            prideNumber++;
                            break;
                        default:
                            if(languageNumer == 1)
                                System.out.println("ورودی غیر مجاز!");
                            else if(languageNumer == 2)
                                System.out.println("Invalid Entry!");
                    }
                    break;
                case 3:
                    if(languageNumer == 1)
                        System.out.println("شماره پلاک خودرو مورد نظر را وارد کنید:" );
                    else if(languageNumer == 2)
                        System.out.println("Enter the license plate number of car:");
                    Scanner pelaak = new Scanner(System.in);
                    newLicensePlateNumber = pelaak.nextInt();
                    findCar(newLicensePlateNumber);
                    break;
                case 9:
                    languageSelection();
                    break;
                case 0:
                    break;
                default:
                    if(languageNumer == 1)
                        System.out.println("ورودی غیر مجاز!");
                    else if(languageNumer == 2)
                        System.out.println("Invalid Entry!");

            }
        }while(uiNumber!=0);
    }

    private void showCars(){
        System.out.println("------------------------------------");
        if(languageNumer == 1)
            System.out.println("تعداد خودروهای موجود: " +
                    (benzNumber+bmwNumber+peugeotNumber+samandNumber+prideNumber));
        else if(languageNumer == 2)
            System.out.println("Number of available cars: " +
                    (benzNumber+bmwNumber+peugeotNumber+samandNumber+prideNumber));
        System.out.println("------------------------------------");
        showCar(benzs,benzNumber);
        showCar(bmws,bmwNumber);
        showCar(peugeots,peugeotNumber);
        showCar(samands,samandNumber);
        showCar(prides,prideNumber);

    }

    private void createNewCar(Car[] cars, int carNumber){
        cars[carNumber].licensePlateNumber = initializeLicensePlateNumber();
        checkLicensePlateNumber(cars, carNumber, cars[carNumber].licensePlateNumber);
        cars[carNumber].color = initializeColor();
        cars[carNumber].modelYear = initializeModelYear();
        cars[carNumber].chassisNumber = initializeChassisNumber();
        cars[carNumber].topSpeed = initializeTopSpeed();
        cars[carNumber].fuelTankCapacity = initializeFuelTankCapacity();
    }

    private void findCar(long newLicensePlateNumber){
        carFindNumber = 0;
        int c = 0;
        while (c<Car.benzNumber){
            findCarSub(benzs,c,newLicensePlateNumber);
            c++;
        }
        c = 0;
        while (c<Car.bmwNumber){
            findCarSub(bmws,c,newLicensePlateNumber);
            c++;
        }
        c = 0;
        while (c<Car.peugeotNumber){
            findCarSub(peugeots,c,newLicensePlateNumber);
            c++;
        }
        c = 0;
        while (c<Car.samandNumber){
            findCarSub(samands,c,newLicensePlateNumber);
            c++;
        }
        c = 0;
        while (c<Car.prideNumber){
            findCarSub(prides,c,newLicensePlateNumber);
            c++;
        }
        if(carFindNumber==0)
            if(languageNumer == 1)
                System.out.println("خودروی مورد نظر یافت نشد.");
            else if (languageNumer == 2)
                System.out.println("No such car not found.");
    }

    private void findCarSub(Car[] cars, int carNumber,long newLicensePlateNumber){
        int i=0,j=0;
        while (i<=carNumber){
            if(j!=0)
                break;
            else if(cars[carNumber].getLicensePlateNumber() == newLicensePlateNumber){
                writeCarsName(cars);
                if(languageNumer == 1) {
                    System.out.println("شماره پلاک: " + cars[carNumber].getLicensePlateNumber());
                    System.out.println("رنگ خودرو: " + cars[carNumber].getColor());
                    System.out.println("سال ساخت: " + cars[carNumber].getModelYear());
                    System.out.println("شماره شاسی: " + cars[carNumber].getChassisNumber());
                    System.out.println("حداکثر سرعت: " + cars[carNumber].getTopSpeed());
                    System.out.println("ظرفیت باک: " + cars[carNumber].getFuelTankCapacity());
                }
                else if(languageNumer == 2){
                    System.out.println("License Plate Number: " + cars[carNumber].getLicensePlateNumber());
                    System.out.println("Color: " + cars[carNumber].getColor());
                    System.out.println("Model Year: " + cars[carNumber].getModelYear());
                    System.out.println("Chassis Number: " + cars[carNumber].getChassisNumber());
                    System.out.println("Top Speed: " + cars[carNumber].getTopSpeed());
                    System.out.println("Fuel Tank Capacity: " + cars[carNumber].getFuelTankCapacity());
                }
                writeCarsInfo(cars);
                System.out.println("------------------------------------");
                j++;
            }
            i++;
        }
        if(j!=0)
            carFindNumber+=j;
    }

    private void showCar(Car[] cars, int carNumber){
        int i=0,j;
        j=carNumber-1;
        while (i<=j){
                writeCarsName(cars);
            if(languageNumer == 1) {
                System.out.println("شماره پلاک: " + cars[i].getLicensePlateNumber());
                System.out.println("رنگ خودرو: " + cars[i].getColor());
                System.out.println("سال ساخت: " + cars[i].getModelYear());
                System.out.println("شماره شاسی: " + cars[i].getChassisNumber());
                System.out.println("حداکثر سرعت: " + cars[i].getTopSpeed());
                System.out.println("ظرفیت باک: " + cars[i].getFuelTankCapacity());
            }
            else if(languageNumer == 2){
                System.out.println("License Plate Number: " + cars[i].getLicensePlateNumber());
                System.out.println("Color: " + cars[i].getColor());
                System.out.println("Model Year: " + cars[i].getModelYear());
                System.out.println("Chassis Number: " + cars[i].getChassisNumber());
                System.out.println("Top Speed: " + cars[i].getTopSpeed());
                System.out.println("Fuel Tank Capacity: " + cars[i].getFuelTankCapacity());
            }
                writeCarsInfo(cars);
                System.out.println("------------------------------------");
                i++;
        }
    }

    private void declareThemAll(){
        for (int i=0; i < 100; i++)
            benzs[i] = new Car();
        for (int i=0; i < 100; i++)
            bmws[i] = new Car();
        for (int i=0; i < 100; i++)
            peugeots[i] = new Car();
        for (int i=0; i < 100; i++)
            samands[i] = new Car();
        for (int i=0; i < 100; i++)
            prides[i] = new Car();
    }

    private void writeCarsName(Car[] cars){
        if(cars == benzs)
            if(languageNumer == 1)
                System.out.println("مدل خودرو: مرسدس بنز");
            else if(languageNumer == 2)
                System.out.println("Car Brand: Mercedes-Benz");
        else if(cars == bmws)
            if(languageNumer == 1)
                    System.out.println("مدل خودرو: بی ام دبلیو");
            else if(languageNumer == 2)
                    System.out.println("Car Brand: BMW");
        else if(cars == peugeots)
            if(languageNumer == 1)
                    System.out.println("مدل خودرو: پژو");
            else if(languageNumer == 2)
                    System.out.println("Car Brand: Peugeot");
        else if(cars == samands)
            if(languageNumer == 1)
                    System.out.println("مدل خودرو: سمند");
            else if(languageNumer == 2)
                    System.out.println("Car Brand: Samand");
        else if(cars == prides)
            if(languageNumer == 1)
                     System.out.println("مدل خودرو: پراید");
         else if(languageNumer == 2)
                    System.out.println("Car Brand: Pride");
    }

    private void benzInfo(){
        if(languageNumer == 1) {
            System.out.println("امکانات مرسدس بنز:");
            System.out.println("- Traffic Sign Assist");
            System.out.println("- Crosswind Assist");
        }
        else if(languageNumer == 2){
            System.out.println("Mercedes-Benz Features:");
            System.out.println("- Traffic Sign Assist");
            System.out.println("- Crosswind Assist");
        }
    }

    private void bmwInfo(){
        if(languageNumer == 1) {
            System.out.println("امکانات بی ام دبلیو:");
            System.out.println("- صفحه نمایش ۸.۸ اینچی");
            System.out.println("- کنترل صوتی روی فرمان");
            System.out.println("- سنسور پارک دنده عقب");
            System.out.println("- تنظیم ارتفاع");
        }
        else if(languageNumer == 2){
            System.out.println("BMW Features:");
            System.out.println("- 8.8 Inch Display");
            System.out.println("- Stereo control from the wheel");
            System.out.println("- Rear parking sensor");
            System.out.println("- Height Adjustment");
        }

    }

    private void peugeotInfo(){
        if(languageNumer == 1) {
            System.out.println("امکانات پژو:");
            System.out.println("- فرمان هیدرولیک");
            System.out.println("- چراغ مه شکن");
        }
        else if(languageNumer == 2)        {
            System.out.println("Peugeot Features:");
            System.out.println("- Hydraulic steering");
            System.out.println("- Fog lights");
        }
    }

    private void samandInfo(){
        if(languageNumer == 1) {
            System.out.println("امکانات سمند:");
            System.out.println("- فیلتر هوای استاندارد");
            System.out.println("- قاب محافظ پلاک");
        }
        else if(languageNumer == 2){
            System.out.println("Samand Features:");
            System.out.println("- Standard Air Filter");
            System.out.println("- License plate frames");
        }
    }

    private void prideInfo(){
        if(languageNumer == 1) {
            System.out.println("امکانات پراید:");
            System.out.println("- برف پاک کن عقب");
            System.out.println("- قفل مرکزی");
        }
        else if(languageNumer == 2){
            System.out.println("Pride Features:");
            System.out.println("- Rear windscreen wiper");
            System.out.println("- Central lock");
        }
    }

    private void writeCarsInfo(Car[] cars){
        if(cars == benzs)
            benzs[benzNumber].benzInfo();
        else if(cars == bmws)
            bmws[bmwNumber].bmwInfo();
        else if(cars == peugeots)
            peugeots[peugeotNumber].peugeotInfo();
        else if(cars == samands)
           samands[samandNumber].samandInfo();
        else if(cars == prides)
            prides[prideNumber].prideInfo();
    }

    private void checkLicencePlateNumberValidation(Car[] cars, int carNumber, long newLicensePlateNumber){
        int i=0,j,s;
        s=0;
        j=carNumber-1;
        while (i<=j){
            if(cars[i].getLicensePlateNumber() == newLicensePlateNumber)
                s++;
            i++;
        }
        if(s!=0)
            pelaakError += s;
    }

    private void checkLicensePlate(long newLicensePlateNumber){
        pelaakError = 0;
        checkLicencePlateNumberValidation(benzs,benzNumber,newLicensePlateNumber);
        checkLicencePlateNumberValidation(bmws,bmwNumber,newLicensePlateNumber);
        checkLicencePlateNumberValidation(peugeots,peugeotNumber,newLicensePlateNumber);
        checkLicencePlateNumberValidation(samands,samandNumber,newLicensePlateNumber);
        checkLicencePlateNumberValidation(prides,prideNumber,newLicensePlateNumber);
    }

    private void checkLicensePlateNumber(Car[] cars,int carNumber, long newLicensePlateNumber){
        checkLicensePlate(newLicensePlateNumber);
        while(pelaakError != 0){
            if(languageNumer == 1)
                System.out.println("این پلاک قبلا ثبت شده است! پلاک جدیدی انتخاب کنید.");
            else if(languageNumer == 2)
                System.out.println("This plate number is already taken! choose a new one.");
            cars[carNumber].licensePlateNumber = initializeLicensePlateNumber();
            checkLicensePlate(cars[carNumber].licensePlateNumber );
        }
    }

    private long initializeLicensePlateNumber(){
        if (languageNumer == 1)
        System.out.println("شماره پلاک را وارد کنید:");
        else if(languageNumer == 2)
            System.out.println("Enter the license plate number:");
        Scanner input = new Scanner(System.in);
        setLicensePlateNumber(input.nextLong());
        return getLicensePlateNumber();
    }

    private long initializeChassisNumber(){
        if (languageNumer == 1)
            System.out.println("شماره شاسی را وارد کنید:");
        else if(languageNumer == 2)
            System.out.println("Enter the chassis number:");
        Scanner input = new Scanner(System.in);
        setChassisNumber(input.nextLong());
        return getChassisNumber();
    }

    private int initializeModelYear(){
        if (languageNumer == 1)
            System.out.println("سال ساخت خودرو را وارد کنید:");
        else if(languageNumer == 2)
            System.out.println("Enter the model year of the car:");
        Scanner input = new Scanner(System.in);
        setModelYear(input.nextInt());
        return getModelYear();
    }

    private int initializeTopSpeed(){
        if(languageNumer == 1)
            System.out.println("حداکثر سرعت را وارد کنید:");
        else if(languageNumer == 2)
            System.out.println("Enter the top speed:");
        Scanner input = new Scanner(System.in);
        setTopSpeed(input.nextInt());
        return getTopSpeed();
    }

    private int initializeFuelTankCapacity(){
        if(languageNumer == 1)
            System.out.println("ظرفیت باک را وارد کنید:");
        else if(languageNumer == 2)
            System.out.println("Enter the fuel tank capacity:");
        Scanner input = new Scanner(System.in);
        setFuelTankCapacity(input.nextInt());
        return getFuelTankCapacity();
    }

    private String initializeColor(){
        if(languageNumer == 1)
            System.out.println("رنگ خودرو را وارد کنید:");
        else if(languageNumer == 2)
            System.out.println("Enter the color of the car:");
        Scanner input = new Scanner(System.in);
        setColor(input.nextLine());
        return getColor();
    }

    private void setLicensePlateNumber(long licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    private void setChassisNumber(long chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    private void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    private void setFuelTankCapacity(int fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    private void setColor(String color) {
        this.color = color;
    }

    private void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    private int getModelYear() {
        return this.modelYear;
    }

    private String getColor() {
        return this.color;
    }

    private long getLicensePlateNumber() {
        return this.licensePlateNumber;
    }

    private long getChassisNumber() {
        return this.chassisNumber;
    }

    private int getTopSpeed() {
        return this.topSpeed;
    }

    private int getFuelTankCapacity() {
        return this.fuelTankCapacity;
    }
}
