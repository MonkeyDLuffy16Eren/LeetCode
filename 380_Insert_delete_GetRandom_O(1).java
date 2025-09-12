class RandomizedSet {
    List<Integer> list;
    HashMap<Integer,Integer> map;
    Random random = new Random();
    public RandomizedSet() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer,Integer>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int pos = map.get(val);
        if(pos!= (list.size()-1)){
            int lastElement = list.get(list.size()-1);
            list.set(pos,lastElement);
            map.put(lastElement,pos);
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    public int getRandom() {
        int randomInt = random.nextInt(list.size());
        return list.get(randomInt);
    }
}