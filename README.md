# Java Practice Repository

A comprehensive collection of Java implementations covering Data Structures, Algorithms, Design Patterns, Concurrency, and LeetCode problems.

## 📚 Table of Contents

- [Concurrency](#concurrency)
- [Cracking the Coding Interview (CTC)](#cracking-the-coding-interview-ctc)
- [Design Patterns](#design-patterns)
- [Data Structures & Algorithms (DSA)](#data-structures--algorithms-dsa)
- [Java Examples](#java-examples)
- [LeetCode Solutions](#leetcode-solutions)
- [Low-Level Design (LLD)](#low-level-design-lld)

---

## 🔄 Concurrency

### Basics
- [MyRunnable.java](src/concurrency/basics/MyRunnable.java) - Runnable implementation example
- [MyThread.java](src/concurrency/basics/MyThread.java) - Thread extension example
- [MyThreadDriver.java](src/concurrency/basics/MyThreadDriver.java) - Thread driver
- [RunnableDriver.java](src/concurrency/basics/RunnableDriver.java) - Runnable driver

### Prime Number Calculations
- [P01_CalculateNthPrimeWithNoConcurrency.java](src/concurrency/prime/P01_CalculateNthPrimeWithNoConcurrency.java) - Sequential approach
- [P02_CalculateNthPrimeWithConcurrency.java](src/concurrency/prime/P02_CalculateNthPrimeWithConcurrency.java) - Concurrent approach
- [P03_CalculateNthPrimeWithConcurrencyDaemon.java](src/concurrency/prime/P03_CalculateNthPrimeWithConcurrencyDaemon.java) - Daemon threads
- [PrimeNumberUtil.java](src/concurrency/prime/PrimeNumberUtil.java) - Prime utilities

---

## 📖 Cracking the Coding Interview (CTC)

- [CheckPermutation.java](src/ctc/CheckPermutation.java) - Check if strings are permutations
- [IsUnique.java](src/ctc/IsUnique.java) - Check if string has unique characters
- [OneAway.java](src/ctc/OneAway.java) - One edit distance check
- [StringCompression.java](src/ctc/StringCompression.java) - String compression
- [URLify.java](src/ctc/URLify.java) - Replace spaces in URL

---

## 🏗️ Design Patterns

### Builder Pattern
- [BuilderDriver.java](src/designpatterns/builder/BuilderDriver.java)
- [Vehicle.java](src/designpatterns/builder/Vehicle.java)

### Composite Pattern
- [Account.java](src/designpatterns/composite/Account.java)
- [Client.java](src/designpatterns/composite/Client.java)
- [CompositeAccount.java](src/designpatterns/composite/CompositeAccount.java)
- [DepositAccount.java](src/designpatterns/composite/DepositAccount.java)
- [SavingAccount.java](src/designpatterns/composite/SavingAccount.java)

### Decorator Pattern
- [BasicDress.java](src/designpatterns/decorator/BasicDress.java)
- [CasualDress.java](src/designpatterns/decorator/CasualDress.java)
- [Client.java](src/designpatterns/decorator/Client.java)
- [Dress.java](src/designpatterns/decorator/Dress.java)
- [DressDecorator.java](src/designpatterns/decorator/DressDecorator.java)
- [FancyDress.java](src/designpatterns/decorator/FancyDress.java)
- [SportyDress.java](src/designpatterns/decorator/SportyDress.java)

### Factory Pattern
- [Bike.java](src/designpatterns/factory/Bike.java)
- [Car.java](src/designpatterns/factory/Car.java)
- [FactoryDriver.java](src/designpatterns/factory/FactoryDriver.java)
- [Vehicle.java](src/designpatterns/factory/Vehicle.java)
- [VehicleFactory.java](src/designpatterns/factory/VehicleFactory.java)

### Singleton Pattern
- [SingletonBlockSynchronized.java](src/designpatterns/singleton/SingletonBlockSynchronized.java)
- [SingletonDriver.java](src/designpatterns/singleton/SingletonDriver.java)
- [SingletonEager.java](src/designpatterns/singleton/SingletonEager.java)
- [SingletonLazy.java](src/designpatterns/singleton/SingletonLazy.java)
- [SingletonSynchronized.java](src/designpatterns/singleton/SingletonSynchronized.java)

### Structural Patterns

#### Adapter Pattern
- [AdapterDesignPatterDriver.java](src/designpatterns/structural/adaptor/AdapterDesignPatterDriver.java)
- [ChromeDriver.java](src/designpatterns/structural/adaptor/ChromeDriver.java)
- [IEDriver.java](src/designpatterns/structural/adaptor/IEDriver.java)
- [WebDriver.java](src/designpatterns/structural/adaptor/WebDriver.java)
- [WebDriverAdaptor.java](src/designpatterns/structural/adaptor/WebDriverAdaptor.java)

#### Bridge Pattern
- [BridgeDriver.java](src/designpatterns/structural/bridge/BridgeDriver.java)
- [NewRemote.java](src/designpatterns/structural/bridge/NewRemote.java)
- [OldRemote.java](src/designpatterns/structural/bridge/OldRemote.java)
- [PhillipsTV.java](src/designpatterns/structural/bridge/PhillipsTV.java)
- [Remote.java](src/designpatterns/structural/bridge/Remote.java)
- [SonyTV.java](src/designpatterns/structural/bridge/SonyTV.java)
- [TV.java](src/designpatterns/structural/bridge/TV.java)

---

## 🗂️ Data Structures & Algorithms (DSA)

### Arrays

#### Sliding Window
- [FindAllAnagramsInAString.java](src/dsa/array/slidingwindow/FindAllAnagramsInAString.java)
- [FirstNegativeIntegerInSubArray.java](src/dsa/array/slidingwindow/FirstNegativeIntegerInSubArray.java)
- [LargestSubarrayOfSumK.java](src/dsa/array/slidingwindow/LargestSubarrayOfSumK.java)
- [LongestSubstringWithKUniqueCharacters.java](src/dsa/array/slidingwindow/LongestSubstringWithKUniqueCharacters.java)
- [LongestSubstringWithoutRepeatingCharacters.java](src/dsa/array/slidingwindow/LongestSubstringWithoutRepeatingCharacters.java)
- [MaximumSubArraySum.java](src/dsa/array/slidingwindow/MaximumSubArraySum.java)
- [MinimumWindowSubstring.java](src/dsa/array/slidingwindow/MinimumWindowSubstring.java)
- [SlidingWindowMaximum.java](src/dsa/array/slidingwindow/SlidingWindowMaximum.java)

#### Sorting
- [BubbleSort.java](src/dsa/array/sort/BubbleSort.java)
- [InsertionSort.java](src/dsa/array/sort/InsertionSort.java)
- [MergeSort.java](src/dsa/array/sort/MergeSort.java)
- [SelectionSort.java](src/dsa/array/sort/SelectionSort.java)

### Backtracking
- [LetterCominationOfPhoneNumber.java](src/dsa/backtracking/LetterCominationOfPhoneNumber.java)

### Bit Manipulation
- [SingleNumber.java](src/dsa/bitmanipulation/SingleNumber.java)

### Design Problems
- [DesignTicTacToe.java](src/dsa/design/DesignTicTacToe.java)
- [InsertDeleteGetRandom.java](src/dsa/design/InsertDeleteGetRandom.java)
- [LRUCache.java](src/dsa/design/LRUCache.java)
- [MinStack.java](src/dsa/design/MinStack.java)
- [SerializeAndDeserializeBinaryTree.java](src/dsa/design/SerializeAndDeserializeBinaryTree.java)

### Depth-First Search (DFS)
- [RatMaze.java](src/dsa/dfs/RatMaze.java)

### Dynamic Programming (DP)

#### DP - Knapsack Pattern
- [CountOfSubsetSum.java](src/dsa/dp/knapsack/CountOfSubsetSum.java)
- [EqualSumPartition.java](src/dsa/dp/knapsack/EqualSumPartition.java)
- [Knapsack.java](src/dsa/dp/knapsack/Knapsack.java)
- [LongestCommonSubsequence.java](src/dsa/dp/knapsack/LongestCommonSubsequence.java)
- [SubsetSum.java](src/dsa/dp/knapsack/SubsetSum.java)

#### DP - Matrix Chain Multiplication
- [MatrixChainMultiplication.java](src/dsa/dp/mcm/MatrixChainMultiplication.java)
- [PalindromePartitioning.java](src/dsa/dp/mcm/PalindromePartitioning.java)

#### DP - Tree Problems
- [BinaryTreeMaximumPathSum.java](src/dsa/dp/tree/BinaryTreeMaximumPathSum.java)
- [BinaryTreeMaximumPathSumFromAnyNode.java](src/dsa/dp/tree/BinaryTreeMaximumPathSumFromAnyNode.java)
- [DiameterOfBinaryTree.java](src/dsa/dp/tree/DiameterOfBinaryTree.java)
- [DiameterOfNAryTree.java](src/dsa/dp/tree/DiameterOfNAryTree.java)

#### Dynamic Programming (Comprehensive)

##### Introduction
- [fibonacci.java](src/dsa/dynamicprogramming/introduction/fibonacci.java)

##### Longest Common Subsequence (LCS)
- [LongestCommonSubsequence.java](src/dsa/dynamicprogramming/lcs/LongestCommonSubsequence.java)

##### Longest Increasing Subsequence (LIS)
- [LongestIncreasingSubsequence.java](src/dsa/dynamicprogramming/lis/LongestIncreasingSubsequence.java)

##### One-Dimensional Array Problems
- [ClimbingStairs.java](src/dsa/dynamicprogramming/onedimentionalarray/ClimbingStairs.java)
- [FrogJump.java](src/dsa/dynamicprogramming/onedimentionalarray/FrogJump.java)
- [FrogJumpWithKSteps.java](src/dsa/dynamicprogramming/onedimentionalarray/FrogJumpWithKSteps.java)
- [HouseRobber.java](src/dsa/dynamicprogramming/onedimentionalarray/HouseRobber.java)
- [HouseRobberII.java](src/dsa/dynamicprogramming/onedimentionalarray/HouseRobberII.java)

##### Stock Problems
- [BestTimeToBuyAndSellStock.java](src/dsa/dynamicprogramming/stocks/BestTimeToBuyAndSellStock.java)
- [BestTimeToBuyAndSellStockII.java](src/dsa/dynamicprogramming/stocks/BestTimeToBuyAndSellStockII.java)

##### Subsequences
- [CoinChange.java](src/dsa/dynamicprogramming/subsequences/CoinChange.java)
- [CountSubsetsWithDifference.java](src/dsa/dynamicprogramming/subsequences/CountSubsetsWithDifference.java)
- [CountSubsetsWithSumK.java](src/dsa/dynamicprogramming/subsequences/CountSubsetsWithSumK.java)
- [EqualSumPartition.java](src/dsa/dynamicprogramming/subsequences/EqualSumPartition.java)
- [Knapsack.java](src/dsa/dynamicprogramming/subsequences/Knapsack.java)
- [MinimumSubsetSumDifference.java](src/dsa/dynamicprogramming/subsequences/MinimumSubsetSumDifference.java)
- [SubsetSum.java](src/dsa/dynamicprogramming/subsequences/SubsetSum.java)

##### Two-Dimensional Array Problems
- [NinjaTraining.java](src/dsa/dynamicprogramming/twodimentionalarray/NinjaTraining.java)

### Graph Algorithms

#### Bipartite
- [Bipartite.java](src/dsa/graph/bipartite/Bipartite.java)

#### Connected Components
- [ConnectedComponents.java](src/dsa/graph/components/ConnectedComponents.java)

#### Cycle Detection
- [CourseSchedule.java](src/dsa/graph/cycle/CourseSchedule.java)
- [CourseScheduleII.java](src/dsa/graph/cycle/CourseScheduleII.java)
- [DetectCycleInDirectedGraph.java](src/dsa/graph/cycle/DetectCycleInDirectedGraph.java)
- [DetectCycleInUndirectedGraph.java](src/dsa/graph/cycle/DetectCycleInUndirectedGraph.java)

#### Topological Sort
- [TopologicalSort.java](src/dsa/graph/topologicalsort/TopologicalSort.java)

#### Graph Traversal
- [BreadthFirstSearch.java](src/dsa/graph/traversal/BreadthFirstSearch.java)
- [DepthFirstSearch.java](src/dsa/graph/traversal/DepthFirstSearch.java)

#### Core Graph Classes
- [Graph.java](src/dsa/graph/Graph.java)
- [GraphUtil.java](src/dsa/graph/GraphUtil.java)

### Heap / Priority Queue

#### Heap Problems
- [ConnectRopes.java](src/dsa/heap/ConnectRopes.java)
- [FrequencySort.java](src/dsa/heap/FrequencySort.java)
- [KClosestNumbers.java](src/dsa/heap/KClosestNumbers.java)
- [KClosestPoints.java](src/dsa/heap/KClosestPoints.java)
- [KLargestElements.java](src/dsa/heap/KLargestElements.java)
- [KthSmallestElement.java](src/dsa/heap/KthSmallestElement.java)
- [SortKSortedArray.java](src/dsa/heap/SortKSortedArray.java)
- [SumOfElements.java](src/dsa/heap/SumOfElements.java)
- [TopKFrequentNumbers.java](src/dsa/heap/TopKFrequentNumbers.java)

#### K-Way Merge
- [KthSmallestInMSortedList.java](src/dsa/heap/kwaymerge/KthSmallestInMSortedList.java)
- [KthSmallestNumberInASortedMatrix.java](src/dsa/heap/kwaymerge/KthSmallestNumberInASortedMatrix.java)
- [MergeKSortedLists.java](src/dsa/heap/kwaymerge/MergeKSortedLists.java)

#### Two Heaps
- [MedianFinder.java](src/dsa/heap/twoheaps/MedianFinder.java)

### Linked List
- [AddTwoNumbers.java](src/dsa/linkedlist/AddTwoNumbers.java)
- [CopyListWithRandomPointer.java](src/dsa/linkedlist/CopyListWithRandomPointer.java)
- [DeleteMiddleNodeOfALinkedList.java](src/dsa/linkedlist/DeleteMiddleNodeOfALinkedList.java)
- [DeleteNodeInALinkedList.java](src/dsa/linkedlist/DeleteNodeInALinkedList.java)
- [InsertIntoASortedLinkedList.java](src/dsa/linkedlist/InsertIntoASortedLinkedList.java)
- [IntersectionOfTwoLinkedLists.java](src/dsa/linkedlist/IntersectionOfTwoLinkedLists.java)
- [LinkedList.java](src/dsa/linkedlist/LinkedList.java)
- [LinkedListCycle.java](src/dsa/linkedlist/LinkedListCycle.java)
- [LinkedListCycleII.java](src/dsa/linkedlist/LinkedListCycleII.java)
- [LinkedListDriver.java](src/dsa/linkedlist/LinkedListDriver.java)
- [ListNode.java](src/dsa/linkedlist/ListNode.java)
- [MergeKSortedLists.java](src/dsa/linkedlist/MergeKSortedLists.java)
- [MergeTwoSortedLists.java](src/dsa/linkedlist/MergeTwoSortedLists.java)
- [OddEvenLinkedList.java](src/dsa/linkedlist/OddEvenLinkedList.java)
- [PalindromeLinkedList.java](src/dsa/linkedlist/PalindromeLinkedList.java)
- [RemoveDuplicatesFromSortedList.java](src/dsa/linkedlist/RemoveDuplicatesFromSortedList.java)
- [RemoveLinkedListElements.java](src/dsa/linkedlist/RemoveLinkedListElements.java)
- [RemoveNthFromEndOfList.java](src/dsa/linkedlist/RemoveNthFromEndOfList.java)
- [RemoveNthNodeFromEndOfList.java](src/dsa/linkedlist/RemoveNthNodeFromEndOfList.java)
- [ReverseLinkedList.java](src/dsa/linkedlist/ReverseLinkedList.java)
- [SwapNodesInLinkedList.java](src/dsa/linkedlist/SwapNodesInLinkedList.java)

### Mathematics
- [Factors.java](src/dsa/mathematics/Factors.java)
- [FindDigits.java](src/dsa/mathematics/FindDigits.java)
- [Prime.java](src/dsa/mathematics/Prime.java)
- [PrimeFactorization.java](src/dsa/mathematics/PrimeFactorization.java)

### Matrix
- [SearchA2DMatrix.java](src/dsa/matrix/SearchA2DMatrix.java)
- [SearchA2DMatrixII.java](src/dsa/matrix/SearchA2DMatrixII.java)
- [SpiralMatrix.java](src/dsa/matrix/SpiralMatrix.java)
- [SpiralMatrixII.java](src/dsa/matrix/SpiralMatrixII.java)
- [WordSearch.java](src/dsa/matrix/WordSearch.java)

### Merge Intervals
- [InsertInterval.java](src/dsa/mergeintervals/InsertInterval.java)
- [MergeIntervals.java](src/dsa/mergeintervals/MergeIntervals.java)

### Number Problems
- [IntegerToRoman.java](src/dsa/number/IntegerToRoman.java)
- [ReverseInteger.java](src/dsa/number/ReverseInteger.java)
- [RomanToInteger.java](src/dsa/number/RomanToInteger.java)
- [SingleNumber.java](src/dsa/number/SingleNumber.java)
- [ValidPalindrome.java](src/dsa/number/ValidPalindrome.java)

### Recursion

#### Basics
- [Factorial.java](src/dsa/recursion/basics/Factorial.java)
- [Fibonacci.java](src/dsa/recursion/basics/Fibonacci.java)
- [Palindrome.java](src/dsa/recursion/basics/Palindrome.java)
- [Print1ToN.java](src/dsa/recursion/basics/Print1ToN.java)
- [PrintNameNTimes.java](src/dsa/recursion/basics/PrintNameNTimes.java)
- [PrintNTo1.java](src/dsa/recursion/basics/PrintNTo1.java)
- [ReverseArray.java](src/dsa/recursion/basics/ReverseArray.java)
- [SumOfNNumbers.java](src/dsa/recursion/basics/SumOfNNumbers.java)

#### Patterns
- [CountAllSubsequenceWithSumK.java](src/dsa/recursion/patterns/CountAllSubsequenceWithSumK.java)
- [PrintAllSubsequences.java](src/dsa/recursion/patterns/PrintAllSubsequences.java)
- [PrintAllSubsequencesWithSumK.java](src/dsa/recursion/patterns/PrintAllSubsequencesWithSumK.java)
- [PrintAnySubsequenceWithSumK.java](src/dsa/recursion/patterns/PrintAnySubsequenceWithSumK.java)

#### Problems
- [CombinationSum.java](src/dsa/recursion/problems/CombinationSum.java)
- [CombinationSumII.java](src/dsa/recursion/problems/CombinationSumII.java)
- [NQueens.java](src/dsa/recursion/problems/NQueens.java)
- [Permutations.java](src/dsa/recursion/problems/Permutations.java)
- [Subsets.java](src/dsa/recursion/problems/Subsets.java)
- [SubsetsII.java](src/dsa/recursion/problems/SubsetsII.java)
- [SubsetSum.java](src/dsa/recursion/problems/SubsetSum.java)

#### Advanced Recursion
- [DeleteMiddleElementInAStack.java](src/dsa/recursion/recursion/DeleteMiddleElementInAStack.java)
- [GenerateAllBalancedParentheses.java](src/dsa/recursion/recursion/GenerateAllBalancedParentheses.java)
- [HeightOfBinaryTree.java](src/dsa/recursion/recursion/HeightOfBinaryTree.java)
- [KthSymbolInGrammar.java](src/dsa/recursion/recursion/KthSymbolInGrammar.java)
- [Print1ToN.java](src/dsa/recursion/recursion/Print1ToN.java)
- [PrintNTo1.java](src/dsa/recursion/recursion/PrintNTo1.java)
- [ReverseStack.java](src/dsa/recursion/recursion/ReverseStack.java)
- [SortAList.java](src/dsa/recursion/recursion/SortAList.java)
- [SortAStack.java](src/dsa/recursion/recursion/SortAStack.java)

### Searching (Binary Search)
- [ArrayRotationCount.java](src/dsa/search/ArrayRotationCount.java)
- [BinarySearch.java](src/dsa/search/BinarySearch.java)
- [BitonicArrayMaximumElement.java](src/dsa/search/BitonicArrayMaximumElement.java)
- [BitonicArraySearch.java](src/dsa/search/BitonicArraySearch.java)
- [CeilOfAnElement.java](src/dsa/search/CeilOfAnElement.java)
- [ElementCount.java](src/dsa/search/ElementCount.java)
- [FirstOccurrenceOfAnElement.java](src/dsa/search/FirstOccurrenceOfAnElement.java)
- [FloorOfAnElement.java](src/dsa/search/FloorOfAnElement.java)
- [LastOccurrenceOfAnElement.java](src/dsa/search/LastOccurrenceOfAnElement.java)
- [LowerBound.java](src/dsa/search/LowerBound.java)
- [MinimumDifferenceElement.java](src/dsa/search/MinimumDifferenceElement.java)
- [MinimumNumberOfPages.java](src/dsa/search/MinimumNumberOfPages.java)
- [NearlySortedArraySearch.java](src/dsa/search/NearlySortedArraySearch.java)
- [NextAlphabeticalElement.java](src/dsa/search/NextAlphabeticalElement.java)
- [OrderAgnosticSearch.java](src/dsa/search/OrderAgnosticSearch.java)
- [PeakElement.java](src/dsa/search/PeakElement.java)
- [ReverseBinarySearch.java](src/dsa/search/ReverseBinarySearch.java)
- [RotatedArraySearch.java](src/dsa/search/RotatedArraySearch.java)
- [SearchInASortedArrayOfUnknownSize.java](src/dsa/search/SearchInASortedArrayOfUnknownSize.java)
- [SearchInRowWiseColumnWiseSortedArray.java](src/dsa/search/SearchInRowWiseColumnWiseSortedArray.java)
- [SingleElementInSortedArray.java](src/dsa/search/SingleElementInSortedArray.java)
- [UpperBound.java](src/dsa/search/UpperBound.java)

### Stack
- [CheckForBalancedParentheses.java](src/dsa/stack/CheckForBalancedParentheses.java)
- [EvaluatePostfixExpression.java](src/dsa/stack/EvaluatePostfixExpression.java)
- [EvaluatePrefixExpression.java](src/dsa/stack/EvaluatePrefixExpression.java)
- [ImplementQueueUsingStack.java](src/dsa/stack/ImplementQueueUsingStack.java)
- [ImplementStackUsingQueue.java](src/dsa/stack/ImplementStackUsingQueue.java)
- [ImplementStackUsingSingleQueue.java](src/dsa/stack/ImplementStackUsingSingleQueue.java)
- [InfixToPostfixExpression.java](src/dsa/stack/InfixToPostfixExpression.java)
- [MaximumAreaHistogram.java](src/dsa/stack/MaximumAreaHistogram.java)
- [MaximumAreaRectangleInBinaryMatrix.java](src/dsa/stack/MaximumAreaRectangleInBinaryMatrix.java)
- [MinStack.java](src/dsa/stack/MinStack.java)
- [MinStackWithoutExtraSpace.java](src/dsa/stack/MinStackWithoutExtraSpace.java)
- [NearestGreaterToLeft.java](src/dsa/stack/NearestGreaterToLeft.java)
- [NearestGreaterToRight.java](src/dsa/stack/NearestGreaterToRight.java)
- [NearestSmallerToLeft.java](src/dsa/stack/NearestSmallerToLeft.java)
- [NearestSmallerToRight.java](src/dsa/stack/NearestSmallerToRight.java)
- [StockSpan.java](src/dsa/stack/StockSpan.java)
- [TrappingRainWater.java](src/dsa/stack/TrappingRainWater.java)

### String
- [ValidAnagram.java](src/dsa/string/ValidAnagram.java)

### Tree

#### Binary Tree Problems
- [BalancedBinaryTree.java](src/dsa/tree/binarytree/BalancedBinaryTree.java)
- [BinaryTreeMaximumPathSum.java](src/dsa/tree/binarytree/BinaryTreeMaximumPathSum.java)
- [BinaryTreeMaximumPathSumFromAnyNode.java](src/dsa/tree/binarytree/BinaryTreeMaximumPathSumFromAnyNode.java)
- [BottomView.java](src/dsa/tree/binarytree/BottomView.java)
- [BoundaryTraversal.java](src/dsa/tree/binarytree/BoundaryTraversal.java)
- [Diameter.java](src/dsa/tree/binarytree/Diameter.java)
- [FlattenBinaryTreeToLinkedList.java](src/dsa/tree/binarytree/FlattenBinaryTreeToLinkedList.java)
- [LeftSideView.java](src/dsa/tree/binarytree/LeftSideView.java)
- [LowestCommonAncestor.java](src/dsa/tree/binarytree/LowestCommonAncestor.java)
- [MaximumWidthOfBinaryTree.java](src/dsa/tree/binarytree/MaximumWidthOfBinaryTree.java)
- [RightSideView.java](src/dsa/tree/binarytree/RightSideView.java)
- [RootToNodePath.java](src/dsa/tree/binarytree/RootToNodePath.java)
- [SerializeAndDeserializeBinaryTree.java](src/dsa/tree/binarytree/SerializeAndDeserializeBinaryTree.java)
- [SymmetricTree.java](src/dsa/tree/binarytree/SymmetricTree.java)
- [TopView.java](src/dsa/tree/binarytree/TopView.java)
- [VerticalOrderTraversal.java](src/dsa/tree/binarytree/VerticalOrderTraversal.java)
- [ZigzagLevelOrderTraversal.java](src/dsa/tree/binarytree/ZigzagLevelOrderTraversal.java)

#### Binary Search Tree (BST)
- [BinarySearchTreeIterator.java](src/dsa/tree/bst/BinarySearchTreeIterator.java)
- [ConstructBSTFromPreorderTraversal.java](src/dsa/tree/bst/ConstructBSTFromPreorderTraversal.java)
- [Delete.java](src/dsa/tree/bst/Delete.java)
- [FindCeil.java](src/dsa/tree/bst/FindCeil.java)
- [FindFloor.java](src/dsa/tree/bst/FindFloor.java)
- [InorderSuccessor.java](src/dsa/tree/bst/InorderSuccessor.java)
- [Insert.java](src/dsa/tree/bst/Insert.java)
- [isValidBST.java](src/dsa/tree/bst/isValidBST.java)
- [KthSmallestElementInABST.java](src/dsa/tree/bst/KthSmallestElementInABST.java)
- [LargestBSTSubtree.java](src/dsa/tree/bst/LargestBSTSubtree.java)
- [LowestCommonAncestor.java](src/dsa/tree/bst/LowestCommonAncestor.java)
- [RecoverBST.java](src/dsa/tree/bst/RecoverBST.java)
- [Search.java](src/dsa/tree/bst/Search.java)
- [TwoSum.java](src/dsa/tree/bst/TwoSum.java)

#### Core Tree Classes
- [BinarySearchTree.java](src/dsa/tree/BinarySearchTree.java)
- [BinarySearchTreeDriver.java](src/dsa/tree/BinarySearchTreeDriver.java)
- [BinaryTree.java](src/dsa/tree/BinaryTree.java)
- [GraphValidTree.java](src/dsa/tree/GraphValidTree.java)
- [Node.java](src/dsa/tree/Node.java)
- [Tree.java](src/dsa/tree/Tree.java)
- [TreeNode.java](src/dsa/tree/TreeNode.java)

### Trie (Prefix Tree)
- [Trie.java](src/dsa/trie/Trie.java)
- [TrieDriver.java](src/dsa/trie/TrieDriver.java)
- [TrieNode.java](src/dsa/trie/TrieNode.java)

### Utilities
- [FrequencyUtil.java](src/dsa/util/FrequencyUtil.java)
- [MathUtil.java](src/dsa/util/MathUtil.java)
- [StringUtil.java](src/dsa/util/StringUtil.java)

### Demo
- [MinHeap.java](src/demo/MinHeap.java)

---

## ☕ Java Examples

- [ComparableExample.java](src/java/examples/ComparableExample.java)
- [ComparatorExample.java](src/java/examples/ComparatorExample.java)

---

## 💻 LeetCode Solutions

### Problem Solutions (by Number)

#### 1-99
- [LC0001_TwoSum.java](src/leetcode/LC0001_TwoSum.java)
- [LC0002_AddTwoNumbers.java](src/leetcode/LC0002_AddTwoNumbers.java)
- [LC0003_LongestSubstringWithoutRepeatingCharacters.java](src/leetcode/LC0003_LongestSubstringWithoutRepeatingCharacters.java)
- [LC0012_IntegerToRoman.java](src/leetcode/LC0012_IntegerToRoman.java)
- [LC0013_RomanToInteger.java](src/leetcode/LC0013_RomanToInteger.java)
- [LC0019_RemoveNthNodeFromEndOfList.java](src/leetcode/LC0019_RemoveNthNodeFromEndOfList.java)
- [LC0020_ValidParentheses.java](src/leetcode/LC0020_ValidParentheses.java)
- [LC0021_MergeTwoSortedLists.java](src/leetcode/LC0021_MergeTwoSortedLists.java)
- [LC0022_GenerateParentheses.java](src/leetcode/LC0022_GenerateParentheses.java)
- [LC0023_MergeKSortedLists.java](src/leetcode/LC0023_MergeKSortedLists.java)
- [LC0024_SwapNodesInPairs.java](src/leetcode/LC0024_SwapNodesInPairs.java)
- [LC0033_SearchInARotatedSortedArray.java](src/leetcode/LC0033_SearchInARotatedSortedArray.java)
- [LC0034_FindFirstAndLastPositionOfElementInSortedArray.java](src/leetcode/LC0034_FindFirstAndLastPositionOfElementInSortedArray.java)
- [LC0039_CombinationSum.java](src/leetcode/LC0039_CombinationSum.java)
- [LC0042_TrappingRainWater.java](src/leetcode/LC0042_TrappingRainWater.java)
- [LC0054_SpiralMatrix.java](src/leetcode/LC0054_SpiralMatrix.java)
- [LC0056_MergeIntervals.java](src/leetcode/LC0056_MergeIntervals.java)
- [LC0057_InsertInterval.java](src/leetcode/LC0057_InsertInterval.java)
- [LC0058_LengthOfTheLastWord.java](src/leetcode/LC0058_LengthOfTheLastWord.java)
- [LC0059_SpiralMatrixII.java](src/leetcode/LC0059_SpiralMatrixII.java)
- [LC0070_ClimbingStairs.java](src/leetcode/LC0070_ClimbingStairs.java)
- [LC0072_SearchA2DMatrix.java](src/leetcode/LC0072_SearchA2DMatrix.java)
- [LC0078_Subsets.java](src/leetcode/LC0078_Subsets.java)
- [LC0081_SearchInRotatedSortedArrayII.java](src/leetcode/LC0081_SearchInRotatedSortedArrayII.java)
- [LC0083_RemoveDuplicatesFromSortedList.java](src/leetcode/LC0083_RemoveDuplicatesFromSortedList.java)
- [LC0084_LargestRectangleInHistogram.java](src/leetcode/LC0084_LargestRectangleInHistogram.java)
- [LC0085_MaximalRectangle.java](src/leetcode/LC0085_MaximalRectangle.java)
- [LC0090_SubsetsII.java](src/leetcode/LC0090_SubsetsII.java)
- [LC0098_ValidateBinarySearchTree.java](src/leetcode/LC0098_ValidateBinarySearchTree.java)

#### 100-199
- [LC0103_BinaryTreeZigZagLevelOrderTraversal.java](src/leetcode/LC0103_BinaryTreeZigZagLevelOrderTraversal.java)
- [LC0111_MinimumDepthOfBinaryTree.java](src/leetcode/LC0111_MinimumDepthOfBinaryTree.java)
- [LC0112_PathSum.java](src/leetcode/LC0112_PathSum.java)
- [LC0113_PathSumII.java](src/leetcode/LC0113_PathSumII.java)
- [LC0114_FlattenBinaryTreeToLinkedList.java](src/leetcode/LC0114_FlattenBinaryTreeToLinkedList.java)
- [LC0116_PopulateNextRightPointerInEachNode.java](src/leetcode/LC0116_PopulateNextRightPointerInEachNode.java)
- [LC0121_BestTimeToBuyAndSellStocks.java](src/leetcode/LC0121_BestTimeToBuyAndSellStocks.java)
- [LC0124_BinaryTreeMaximumPathSum.java](src/leetcode/LC0124_BinaryTreeMaximumPathSum.java)
- [LC0136_SingleNumber.java](src/leetcode/LC0136_SingleNumber.java)
- [LC0138_CopyListWithRandomPointer.java](src/leetcode/LC0138_CopyListWithRandomPointer.java)
- [LC0141_LinkedListCycle.java](src/leetcode/LC0141_LinkedListCycle.java)
- [LC0142_LinkedListCycleII.java](src/leetcode/LC0142_LinkedListCycleII.java)
- [LC0146_LRUCache.java](src/leetcode/LC0146_LRUCache.java)
- [LC0150_EvaluateReversePolishNotation.java](src/leetcode/LC0150_EvaluateReversePolishNotation.java)
- [LC0153_FindMinimumInRotatedSortedArray.java](src/leetcode/LC0153_FindMinimumInRotatedSortedArray.java)
- [LC0154_FindMinimumInRotatedSortedArrayII.java](src/leetcode/LC0154_FindMinimumInRotatedSortedArrayII.java)
- [LC0155_MinStack.java](src/leetcode/LC0155_MinStack.java)
- [LC0160_IntersectionOfTwoLinkedLists.java](src/leetcode/LC0160_IntersectionOfTwoLinkedLists.java)
- [LC0162_FindPeakElement.java](src/leetcode/LC0162_FindPeakElement.java)
- [LC0173_BinarySearchTreeIterator.java](src/leetcode/LC0173_BinarySearchTreeIterator.java)
- [LC0198_HouseRobber.java](src/leetcode/LC0198_HouseRobber.java)

#### 200-299
- [LC0200_NumberOfIslands.java](src/leetcode/LC0200_NumberOfIslands.java)
- [LC0203_RemoveLinkedListElements.java](src/leetcode/LC0203_RemoveLinkedListElements.java)
- [LC0206_ReverseLinkedList.java](src/leetcode/LC0206_ReverseLinkedList.java)
- [LC0207_CourseSchedule.java](src/leetcode/LC0207_CourseSchedule.java)
- [LC0208_ImplementTrie.java](src/leetcode/LC0208_ImplementTrie.java)
- [LC0210_CourseScheduleII.java](src/leetcode/LC0210_CourseScheduleII.java)
- [LC0213_HouseRobberII.java](src/leetcode/LC0213_HouseRobberII.java)
- [LC0215_KthLargestElementInAnArray.java](src/leetcode/LC0215_KthLargestElementInAnArray.java)
- [LC0230_KthSmallestElementInABST.java](src/leetcode/LC0230_KthSmallestElementInABST.java)
- [LC0230_KthSmallestElementInBST.java](src/leetcode/LC0230_KthSmallestElementInBST.java)
- [LC0234_PalindromeLinkedList.java](src/leetcode/LC0234_PalindromeLinkedList.java)
- [LC0235_LowestCommonAncestorOfABinarySearchTree.java](src/leetcode/LC0235_LowestCommonAncestorOfABinarySearchTree.java)
- [LC0236_LowestCommonAncestorOfABinaryTree.java](src/leetcode/LC0236_LowestCommonAncestorOfABinaryTree.java)
- [LC0237_DeleteNodeInALinkedList.java](src/leetcode/LC0237_DeleteNodeInALinkedList.java)
- [LC0239_SlidingWindowMaximum.java](src/leetcode/LC0239_SlidingWindowMaximum.java)
- [LC0240_SearchA2DMatrixII.java](src/leetcode/LC0240_SearchA2DMatrixII.java)
- [LC0261_GraphValidTree.java](src/leetcode/LC0261_GraphValidTree.java)
- [LC0285_InorderSuccessorInBST.java](src/leetcode/LC0285_InorderSuccessorInBST.java)
- [LC0295_FindMedianFromDataStream.java](src/leetcode/LC0295_FindMedianFromDataStream.java)
- [LC0297_SerializeAndDeserializeBinaryTree.java](src/leetcode/LC0297_SerializeAndDeserializeBinaryTree.java)

#### 300-699
- [LC0314_BinaryTreeVerticalOrderTraversal.java](src/leetcode/LC0314_BinaryTreeVerticalOrderTraversal.java)
- [LC0322_CoinChange.java](src/leetcode/LC0322_CoinChange.java)
- [LC0323_NumberOfConnectedComponentsInUndirectedGraph.java](src/leetcode/LC0323_NumberOfConnectedComponentsInUndirectedGraph.java)
- [LC0328_OddEvenLinkedList.java](src/leetcode/LC0328_OddEvenLinkedList.java)
- [LC0336_FindLeavesOfBinaryTree.java](src/leetcode/LC0336_FindLeavesOfBinaryTree.java)
- [LC0373_FindKPairsWithSmallestSum.java](src/leetcode/LC0373_FindKPairsWithSmallestSum.java)
- [LC0404_SumOfLeftLeaves.java](src/leetcode/LC0404_SumOfLeftLeaves.java)
- [LC0416_PartitionEqualSubsetSum.java](src/leetcode/LC0416_PartitionEqualSubsetSum.java)
- [LC0450_DeleteNodeInABST.java](src/leetcode/LC0450_DeleteNodeInABST.java)
- [LC0451_SortCharacterByFrequency.java](src/leetcode/LC0451_SortCharacterByFrequency.java)
- [LC0540_SingleElementInSortedArray.java](src/leetcode/LC0540_SingleElementInSortedArray.java)
- [LC0543_DiameterOfBinaryTree.java](src/leetcode/LC0543_DiameterOfBinaryTree.java)
- [LC0545_BoundaryOfBinaryTree.java](src/leetcode/LC0545_BoundaryOfBinaryTree.java)
- [LC0547_NumberOfProvinces.java](src/leetcode/LC0547_NumberOfProvinces.java)
- [LC0662_MaximumWidthOfBinaryTree.java](src/leetcode/LC0662_MaximumWidthOfBinaryTree.java)
- [LC0692_TopKFrequentWords.java](src/leetcode/LC0692_TopKFrequentWords.java)

#### 700-999
- [LC0700_SearchInABinarySearchTree.java](src/leetcode/LC0700_SearchInABinarySearchTree.java)
- [LC0701_InsertIntoABinarySearchTree.java](src/leetcode/LC0701_InsertIntoABinarySearchTree.java)
- [LC0702_SearchInASortedArrayOfUnknownSize.java](src/leetcode/LC0702_SearchInASortedArrayOfUnknownSize.java)
- [LC0703_KthLargestElementInAStream.java](src/leetcode/LC0703_KthLargestElementInAStream.java)
- [LC0704_BinarySearch.java](src/leetcode/LC0704_BinarySearch.java)
- [LC0707_DesignLinkedList.java](src/leetcode/LC0707_DesignLinkedList.java)
- [LC0708_InsertIntoASortedLinkedList.java](src/leetcode/LC0708_InsertIntoASortedLinkedList.java)
- [LC0724_FindPivotIndex.java](src/leetcode/LC0724_FindPivotIndex.java)
- [LC0739_DailyTemperatures.java](src/leetcode/LC0739_DailyTemperatures.java)
- [LC0744_FindSmallestLetterGreaterThanTarget.java](src/leetcode/LC0744_FindSmallestLetterGreaterThanTarget.java)
- [LC0746_MinCostClimbingStairs.java](src/leetcode/LC0746_MinCostClimbingStairs.java)
- [LC0779_KthSymbolInGrammar.java](src/leetcode/LC0779_KthSymbolInGrammar.java)
- [LC0785_IsGraphBipartite.java](src/leetcode/LC0785_IsGraphBipartite.java)
- [LC0811_SubdomainVisitCount.java](src/leetcode/LC0811_SubdomainVisitCount.java)
- [LC0852_PeakIndexInAMountainArray.java](src/leetcode/LC0852_PeakIndexInAMountainArray.java)
- [LC0876_MiddleOfTheLinkedList.java](src/leetcode/LC0876_MiddleOfTheLinkedList.java)
- [LC0901_OnlineStockSpan.java](src/leetcode/LC0901_OnlineStockSpan.java)
- [LC0973_KClosestPoints.java](src/leetcode/LC0973_KClosestPoints.java)
- [LC0994_RottingOranges.java](src/leetcode/LC0994_RottingOranges.java)

#### 1000+
- [LC1095_FindInMountainArray.java](src/leetcode/LC1095_FindInMountainArray.java)
- [LC1143_LongestCommonSubsequence.java](src/leetcode/LC1143_LongestCommonSubsequence.java)
- [LC1167_MinimumCostToConnectSticks.java](src/leetcode/LC1167_MinimumCostToConnectSticks.java)
- [LC1351_CountNegativeNumberInASortedMatrix.java](src/leetcode/LC1351_CountNegativeNumberInASortedMatrix.java)
- [LC1522_DiameterOfNAryTree.java](src/leetcode/LC1522_DiameterOfNAryTree.java)
- [LC1721_SwapNodesInLinkedList.java](src/leetcode/LC1721_SwapNodesInLinkedList.java)
- [LC1822_SignOfProductOfAnArray.java](src/leetcode/LC1822_SignOfProductOfAnArray.java)
- [LC2095_DeleteMiddleNodeOfALinkedList.java](src/leetcode/LC2095_DeleteMiddleNodeOfALinkedList.java)
- [LC2096_StepByStepDirectionFromOneBinaryTreeNodeToAnother.java](src/leetcode/LC2096_StepByStepDirectionFromOneBinaryTreeNodeToAnother.java)

#### Additional Problems
- [ArrayReader.java](src/leetcode/ArrayReader.java)
- [Atoi.java](src/leetcode/Atoi.java)
- [BinaryTreeMaxDepth.java](src/leetcode/BinaryTreeMaxDepth.java)
- [BreakPalindrome.java](src/leetcode/BreakPalindrome.java)
- [ClimbingStairs.java](src/leetcode/ClimbingStairs.java)
- [ContainsDuplicates.java](src/leetcode/ContainsDuplicates.java)
- [ContainsDuplicatesII.java](src/leetcode/ContainsDuplicatesII.java)
- [FindKClosestElements.java](src/leetcode/FindKClosestElements.java)
- [FindPivotIndex.java](src/leetcode/FindPivotIndex.java)
- [FirstUniqueCharacter.java](src/leetcode/FirstUniqueCharacter.java)
- [GroupAnagrams.java](src/leetcode/GroupAnagrams.java)
- [KthFactor.java](src/leetcode/KthFactor.java)
- [LeastUniqueIntegersKRemovals.java](src/leetcode/LeastUniqueIntegersKRemovals.java)
- [MapSum.java](src/leetcode/MapSum.java)
- [MedianFinder.java](src/leetcode/MedianFinder.java)
- [MeetingRoomsII.java](src/leetcode/MeetingRoomsII.java)
- [MountainArray.java](src/leetcode/MountainArray.java)
- [NextGreaterElement.java](src/leetcode/NextGreaterElement.java)
- [NumberOfIslands.java](src/leetcode/NumberOfIslands.java)
- [OddEvenLinkedList.java](src/leetcode/OddEvenLinkedList.java)
- [RandomPickWithWeight.java](src/leetcode/RandomPickWithWeight.java)
- [ReArrangeWordsInASentence.java](src/leetcode/ReArrangeWordsInASentence.java)
- [ReformatDate.java](src/leetcode/ReformatDate.java)
- [RemoveNthFromEndOfList.java](src/leetcode/RemoveNthFromEndOfList.java)
- [ReorganizeString.java](src/leetcode/ReorganizeString.java)
- [SearchCircularSortedArray.java](src/leetcode/SearchCircularSortedArray.java)
- [SortCharactersByFrequency.java](src/leetcode/SortCharactersByFrequency.java)
- [SortColors.java](src/leetcode/SortColors.java)
- [SpiralMatrix.java](src/leetcode/SpiralMatrix.java)
- [StringCompression.java](src/leetcode/StringCompression.java)
- [TrappingRainWater.java](src/leetcode/TrappingRainWater.java)
- [WordSearch.java](src/leetcode/WordSearch.java)

---

## 🏢 Low-Level Design (LLD)

### Immutability
- [Engine.java](src/lld/immutable/Engine.java)
- [ImmutableCar.java](src/lld/immutable/ImmutableCar.java)
- [ImmutableDriver.java](src/lld/immutable/ImmutableDriver.java)

---

## 📊 Statistics

- **Total Java Files**: 400+
- **Design Patterns**: 5 main patterns with multiple implementations
- **Data Structures**: Arrays, LinkedList, Stack, Queue, Heap, Tree, Graph, Trie
- **Algorithms**: Sorting, Searching, DP, Recursion, Backtracking, DFS, BFS
- **LeetCode Problems**: 200+ solved

---

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Maven (optional, for dependency management)

### Running the Code

1. Clone the repository:
```bash
git clone https://github.com/mohanakrishnavh/practice.git
cd practice
```

2. Compile a specific file:
```bash
javac src/path/to/YourFile.java
```

3. Run the compiled class:
```bash
java -cp src path.to.YourFile
```

---

## 📝 License

This repository is for educational purposes.

---

## 👤 Author

**Mohanakrishna VH**

---

## 🤝 Contributing

This is a personal practice repository. Feel free to fork and use for your own learning!

---

## ⭐ Show Your Support

Give a ⭐️ if this project helped you!
