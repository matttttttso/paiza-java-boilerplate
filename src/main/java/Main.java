import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args ) throws Exception {
        // スキャナー
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String token1 = sc.next();
            String token2 = sc.next();
            System.out.println("hello = " + token1 + " , world = " + token2);
            int n1 = Integer.parseInt(token1);
            int n2 = Integer.parseInt(token2);
            System.out.println(n1 + n2 + String.valueOf(n1 + n2));
        }
        
        // リスト
        List<String> list = new ArrayList<String>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        for (String str : list) {
            System.out.println("list for loop : " + str);
        }
        // リスト stream.filter.collect(), Collectors
        List<String> filteredList = list.stream()
                    .filter(str -> Objects.equals(str, "test3"))
                    .collect(Collectors.toList());
        System.out.println("list.stream.filter.collect(Collectors) " + filteredList.size());
        // リスト stream.filter.findFirst(), Optional
        Optional<String> optStr = list.stream()
                        .filter(str -> Objects.equals(str, "test3"))
                        .findFirst();
        if (optStr.isPresent()) {
            System.out.println("list.stream.filter.findFirst() " + optStr.get());
            // startsWith
            if (optStr.get().startsWith("t")) {
                optStr.get().replace("t", "p");
            }
            // replace
            System.out.println("replace " + optStr.get().replace("t", "p"));
            System.out.println("replaced but " + optStr.get());
        }
        
        // マップ
        Map<String, Test> testMap = new LinkedHashMap<>();
        list.stream().forEach(
            str -> testMap.put(str, new Test(str, str.replace("test", "value")))
        );
        testMap.entrySet().stream().forEach(entry -> {
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue().getValue());
        });
        for (Entry<String, Test> entry : testMap.entrySet()) {
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue().getValue());
        }
    }
    
    static class Test {
        private String key;
        private String value;
        
        public String getKey() {
    		return key;
    	}
    	public void setKey(String key) {
    		this.key = key;
    	}
    	public String getValue() {
    		return value;
    	}
    	public void setValue(String value) {
    		this.value = value;
    	}
        
        public Test(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    
    // input example
    /*
        1 1
        2 2

     */
}
