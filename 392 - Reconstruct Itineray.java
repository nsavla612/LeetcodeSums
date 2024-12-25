class Solution {

  private int numTickets = 0;
    private int numTicketsUsed = 0;

    public List<String> findItinerary(List<List<String>> tickets) {
      
  List<String> route = new LinkedList();
        Map<String, List<String>> targets = new HashMap<>();

        if (tickets == null || tickets.size() == 0) return route;
        numTickets = tickets.size();
        for (int i = 0; i < tickets.size(); ++i)
        {
            if (!targets.containsKey(tickets.get(i).get(0))) 
            {
                // create a new list
                List<String> list = new ArrayList<>();
                list.add(tickets.get(i).get(1));
                targets.put(tickets.get(i).get(0), list);
            } else {
                // add to existing list
                targets.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
            }
        }
    
        for(var entry : targets.entrySet())
        {
            Collections.sort(entry.getValue());
        }

        route.add("JFK");
        visit("JFK", targets, route);

        return route;
    }

    void visit(String airport, Map<String, List<String>> targets, List<String> route) {
            if (!targets.containsKey(airport)) return;
            List<String> list = targets.get(airport);
        for (int i = 0; i < list.size(); ++i) 
        {
                String neighbor = list.get(i);
                list.remove(i);
                route.add(neighbor);
                numTicketsUsed++;
                visit(neighbor, targets, route);
                if (numTickets == numTicketsUsed) return;
                list.add(i, neighbor);
                route.removeLast();
                numTicketsUsed--;
        }

  
    
}
}
