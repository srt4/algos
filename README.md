# algos

## What is this?

This repository contains reference implementations of interview questions I ask and have been asked.

## Your implementation of {some solution} is suboptimal/contains bugs/can be a one-liner

These solutions aren't supposed to be the best implementation, nor necessarily bug free (though I strive for them to be both). Instead, they're my best-attempt at solving them within the time constraints of a phone screen, and typically without an IDE.

In a way, they're an attempt at keeping myself honest - if I'm asking an interview question, I can reasonably expect _approximately_ this level of implementation.

## Algorithms

### JsonPrettyPrinter

Difficulty: Easy/medium

Question: Take an unformatted JSON string and pretty print it.

Competencies:
 * Basic knowledge of JSON as a structure
 * Assigning variables at correct scope
 * Evaluating edge cases
 * Optimal runtime

Complications:
 * Handling indentation
 * Retain original characters

What this implementation lacks:
 * Handling escaped characters (I no longer look for this in interviews)

### ReversePositiveIntegers

Difficulty: Easy

Question: Given a list of integers, positive and negative, reverse the positive ranges of integers

Competencies:
 * List/array traversal
 * In-place updates using temporary variables
 * Corner and base casing

### SinglyLinkedLists::interleaveList

Difficulty: Hard

Competencies:
 * List traversal
 * Pointer reassignment
 * Evaluating edge cases
 * Runtime analysis
 * Divide and conquer, recursion
 * Fast/slow traversal

Complications:
 * Pointer reassignment is particularly tricky on this one
 * Cutting the array in half is key to solving this

### SinglyLinkedLists:isPalindrome

Difficulty: Easy/medium

Competencies:
 * Recursion 
