public class LadderNow {
    public static void foo(){

    }
}

/**
 * 1. Angular (v2+) 2
 * 2. Java 7 (better with v9+)
 * 3. Spring 7
 * 4. SQL 7
 * 5. Frontend Web Development 3
 * 6. Backend Architecture 7
 * Only Positive
 * Implement the following function that takes in a list of integers and returns a new list containing only the positive integers:
 * Ex: onlyPositive([3, -2, 5, -10, 0, 1, 4]) => [3, 5, 1, 4]
 * [Typescript]
 * Import lodash;
 * function onlyPositive(input: number[]): number[] {
 *    // TODO Implement
 * return _(number).filter(x -> x > 0)
 * }
 * [Java]
 * Import java.util.stream.Collectors;
 * Import java.util.*;//not sure whats needed for stream exactly, might just be Stream but this would work to be safe.
 * List<Integer> onlyPositive(List<Integer> input) {
 * // TODO Implement
 * return input.stream().filter(x-> x>0).collect(Collectors.toList());
 * }
 *
 * Most Frequent Letter
 * Implement the following function that takes a string of alphabetical characters A-Z and returns the most frequently seen letter.
 * Ex: mostFrequentLetter(“babaac”) => “a”
 * [Java]
 * String mostFrequentLetter(String input) {
 * /// TODO Implement: Code Here
 * //i think there is a better way to use a grouping by and a stream, but were timed so this will work
 * HashMap map = new HashMap<Character,Integer>();
 * input.chars().foreach( char -> {
 * if(map.containsKey(char)) map.put(char,map.get(char)+1)
 * else map.put(char);
 * return map.stream().sorted(Comparator.reverseOrder).Collect(Collectors.toList).first();//assumes a non empty collection
 * }
 * }
 * [Typescript]
 * Import ldoash;
 * function mostFrequentLetter(input: string): string {
 * return _(input).countby[ch].sortBy(‘desc’).first()
 * }
 * Databases
 * SQL
 * Query a database table name jobs for the total number of jobs per day, ordered by chronological date. 
 * Table: jobs
 * Fields: id: integer (Primary Key)
 * date: Date
 * Example output:
 * Date, # Jobs
 * 3-1-2020, 30
 * 3-2-2020, 19
 * 3-3-2020, 55
 *
 * // TODO Implement HERE
 * select date, count(*) as ‘# jobs’ from jobs group by date
 *
 * Javascript API Fetching
 * Given the following object types:
 * Job: { jobId: number, inspectorId: number }
 * Inspector: { inspectorId: number, name: string }
 * Suppose you have an API client with the following functions:
 * fetchJobById(jobId) => returns a Promise of a Job object
 * fetchInspectorById(inspectorId) => returns a Promise of an Inspector object
 * Write a function that will return the Inspector object for a given jobId. You may assume the API client functions are already imported and available to use by name. 
 * //assuming node js?
 * function findInspectorForJob(jobId) {
 * Const Promise job => new Promise((resolve,reject)=>fetchJobById(jobId))
 * Return Const Promise inspector = job.then( job => new Promise((resolve,reject)=> resolve fetchInspectorById(job.id))
 * }
 */
