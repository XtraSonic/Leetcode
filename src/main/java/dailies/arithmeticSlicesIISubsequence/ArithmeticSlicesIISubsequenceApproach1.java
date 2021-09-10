package dailies.arithmeticSlicesIISubsequence;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ArithmeticSlicesIISubsequenceApproach1 implements ArithmeticSlicesIISubsequence {

    @Override
    public int numberOfArithmeticSlices(int[] nums) {
        List<ArithmeticSequence> sequences = new LinkedList<>();

        for (int num : nums) {
            for (ListIterator<ArithmeticSequence> seqIt = sequences.listIterator(); seqIt.hasNext(); ) {
                ArithmeticSequence seq = seqIt.next();
                if (seq.fits(num)) {
                    seqIt.add(new ArithmeticSequence(seq, num));
                }
            }
            sequences.add(new ArithmeticSequence(num));
        }

        return Math.toIntExact(sequences.stream().filter(sequence -> sequence.size() >= 3).count());
    }

    static class ArithmeticSequence {
        int numberOfNumbersInSequence;
        int lastNumberInSequence;
        int difOfTheSequence;

        public ArithmeticSequence(int nr) {
            numberOfNumbersInSequence = 1;
            lastNumberInSequence = nr;
        }

        public ArithmeticSequence(ArithmeticSequence old, int nr) {
            numberOfNumbersInSequence = old.numberOfNumbersInSequence + 1;
            lastNumberInSequence = nr;
            difOfTheSequence = old.lastNumberInSequence - nr;
        }


        public int size() {
            return numberOfNumbersInSequence;
        }

        public boolean fits(int num) {
            return numberOfNumbersInSequence < 2 || difOfTheSequence == (long) lastNumberInSequence - num;
        }
    }

//        List<SequenceSummary> listOfSubsequences = new LinkedList<>();
//        for (int currentNumber : nums) {
//            for(ListIterator<SequenceSummary> seqIt = listOfSubsequences.listIterator();seqIt.hasNext();){
//                SequenceSummary seq = seqIt.next();
//                if (seq.lastNumberInSequence - currentNumber == seq.difOfTheSequence || seq.numberOfNumbersInSequence ==1) {
//                    if(seq.numberOfNumbersInSequence ==1){
//                        seq.difOfTheSequence = seq.lastNumberInSequence - currentNumber;
//                    }
//                    seq.numberOfNumbersInSequence++;
//                    seq.lastNumberInSequence = currentNumber;
//                }else {
//                    seqIt.add(new SequenceSummary(currentNumber,seq.lastNumberInSequence-currentNumber,2));
//                }
//            }
//            listOfSubsequences.add(new SequenceSummary(currentNumber,0,1));
//        }
//        return listOfSubsequences.stream().map((entry) -> {
//            int value = entry.numberOfNumbersInSequence;
//            if (value < 3)
//                return 0;
//            if (entry.difOfTheSequence == 0) {
//                return (1 << value) - 1 - value - (value * (value - 1)) / 2;
//            } else {
//                return (value - 2) * (value - 1) / 2;
//            }
//        }).mapToInt(e -> e).reduce(Integer::sum).orElse(0);
//    }
//
//    static class SequenceSummary{
//        int numberOfNumbersInSequence;
//        int lastNumberInSequence;
//        int difOfTheSequence;
//
//        public SequenceSummary(int lastNumberInSequence, int difOfTheSequence, int numberOfNumbersInSequence) {
//            this.numberOfNumbersInSequence = numberOfNumbersInSequence;
//            this.lastNumberInSequence = lastNumberInSequence;
//            this.difOfTheSequence = difOfTheSequence;
//        }
//    }

}
