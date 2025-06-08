class SmallestInfiniteSet {
    Queue<Integer> smallestNaturalNumbers;
    Set<Integer> werePopped;
    public SmallestInfiniteSet() {
        smallestNaturalNumbers = new PriorityQueue<>();
        werePopped = new HashSet<>();
        for (int i = 1; i <= 1000; i++) {
            smallestNaturalNumbers.offer(i);
        }
    }

    public int popSmallest() {
        int num = smallestNaturalNumbers.poll();
        werePopped.add(num);
        return num;
    }

    public void addBack(int num) {
        if (werePopped.contains(num)){
            smallestNaturalNumbers.offer(num);
            werePopped.remove(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */