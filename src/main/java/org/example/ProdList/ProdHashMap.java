package org.example.ProdList;
import java.util.*;
import java.util.stream.Collectors;

public class ProdHashMap implements Comparable<ProdHashMap> {
    private String pName;
    private double cost;
    private String brand;
    private String category;
    private float rating;
    private float disPerc;

    public ProdHashMap(int pid,String pName,  String category, String brand, double cost,float disPerc, float rating) {
        this.pid = pid;
        this.pName = pName;
        this.category = category;
        this.brand = brand;
        this.cost = cost;
        this.disPerc = disPerc;
        this.rating = rating;
    }

    private int pid;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getDisPerc() {
        return disPerc;
    }

    @Override
    public String toString() {
        return
                "pName='" + pName + '\'' +
                ", cost=" + cost +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", disPerc=" + disPerc +
                ", pid=" + pid ;
    }

    public void setDisPerc(float disPerc) {
        this.disPerc = disPerc;
    }

    private  static HashMap<Integer,ProdHashMap> productMap = new HashMap<>();

    public static void addProductMap(ProdHashMap prod){
        productMap.put(prod.getPid(),prod);
    }


    public static void sortByCostAsc(){
//        List<ProdHashMap> prodList= new ArrayList<>(productMap.values());
//        Collections.sort( prodList,(p1,p2)->
//                Double.compare(p1.getCost(),p2.getCost()));
//        for(ProdHashMap p:prodList){
//            System.out.println("id: "+ p.getPid()+ " - "+ p);
//        }
        System.out.println(productMap.values().stream().sorted(Comparator.comparing(ProdHashMap::getCost)));
    }


    public static Map<Integer,ProdHashMap> sortByBrandDescAndPidAscending(){
        return (productMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, ProdHashMap>comparingByValue(Comparator.comparing(ProdHashMap::getBrand).reversed())
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                )));
    }

    public static void sortByCostDesc(){
//        List<ProdHashMap> prodList= new ArrayList<>(productMap.values());
//        Collections.sort(prodList,(p1,p2)->
//                Double.compare(p2.getCost(),p1.getCost()));
//        for(ProdHashMap p:prodList){
//            System.out.println("id: "+ p.getPid()+ " - "+ p);
//        }
        System.out.println(productMap.values().stream().sorted(Comparator.comparing(ProdHashMap::getCost).reversed()));
    }

    public static void sortByDiscAsc(){
//        List<ProdHashMap> prodList= new ArrayList<>(productMap.values());
//        Collections.sort(prodList,(p1,p2)->
//                Double.compare(p1.getDisPerc(),p2.getDisPerc()));
//        for(ProdHashMap p:prodList){
//            System.out.println("id: "+ p.getPid()+ " - "+ p);
//        }
        System.out.println(productMap.values().stream().sorted(Comparator.comparing(ProdHashMap::getDisPerc)));
    }

    public static void sortByDiscDesc(){
//        List<ProdHashMap> prodList= new ArrayList<>(productMap.values());
//        Collections.sort(prodList,(p1,p2)->
//                Double.compare(p2.getDisPerc(),p1.getDisPerc()));
//        for(ProdHashMap p:prodList){
//            System.out.println("id: "+ p.getPid()+ " - "+ p);
//        }
        System.out.println(productMap.values()
                .stream()
                .sorted(Comparator.comparing(ProdHashMap::getDisPerc).reversed()));
    }

    public static void sortByRatingAsc(){
//        List<ProdHashMap> prodList= new ArrayList<>(productMap.values());
//        Collections.sort(prodList,(p1,p2)->
//                Double.compare(p2.getRating(),p1.getRating()));
//        for(ProdHashMap p:prodList){
//            System.out.println("id: "+ p.getPid()+ " - "+ p);
//        }
        System.out.println(productMap.values()
                .stream()
                .sorted(Comparator.comparing(ProdHashMap::getRating)));
    }

    public static void sortByRatingDesc(){
        List<ProdHashMap> prodList= new ArrayList<>(productMap.values());
        Collections.sort(prodList,(p1,p2)->
                Double.compare(p2.getRating(),p1.getRating()));
        for(ProdHashMap p:prodList){
            System.out.println("id: "+ p.getPid()+ " - "+ p);
        }
    }

//        public List<ProdHashMap> filterByName(String pName){
//        List<ProdHashMap> filteredList = new LinkedList<>();
//            for(ProdHashMap p :productMap.values()){
//                if(p.getpName().equals(pName)){
//                    filteredList.add(p);
//                }
//
//            return filteredList;
//        }

    public static void filterByName(String pName){
//        for(Map.Entry<Integer,ProdHashMap>e:productMap.entrySet()){
//            if(pName.equals(e.getValue().getpName())){
//                System.out.println("id: "+ e.getKey()+ " - "+ e.getValue());
//            }
//        }
        System.out.println(productMap.values()
                .stream()
                .filter( prodHashMap -> pName.equals(prodHashMap.getpName()))
                .toList());
    }

    public static void filterByBrand(String brand) {
//        for(Map.Entry<Integer,ProdHashMap>e:productMap.entrySet()){
//            if(brand.equals(e.getValue().getBrand())){
//                System.out.println("id: "+ e.getKey()+ " - "+ e.getValue());
//            }
//        }
        System.out.println(productMap.values()
                .stream()
                .filter( prodHashMap -> brand.equals(prodHashMap.getBrand()))
                .toList());
    }

    public static void filterByCategory(String category){
        for(Map.Entry<Integer,ProdHashMap>e:productMap.entrySet()){
            if(category.equals(e.getValue().getCategory())){
                System.out.println("id: "+ e.getKey()+ " - "+ e.getValue());
            }
        }
    }

    public static void filterByCostRange(double minCost,double maxCost){
        for(Map.Entry<Integer, ProdHashMap>e:productMap.entrySet()){
            if(minCost<=e.getValue().getCost() && maxCost>=e.getValue().getCost()){
                System.out.println("id: "+e.getKey()+ " - "+e.getValue());
            }
        }
    }

    public int compareTo(ProdHashMap o) {
        return this.getBrand().compareTo(productMap.get(o).getBrand());
    }


}
