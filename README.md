# Packaging Size Testing

Test packaging sizes based on including various aspects of the scala langugage or external libraries.

To run a test, it is also necessary to sometimes perform a small trivial computation in order to ensure that the code is not removed during dead-code elimination phases.

Only fullOptJS compiles count. fastOptJS is not used in production and is significantly larger of course.

A main def is defined in each test so that there is an entry point defined although this is not essential. Measurements are in bytes unless otherwise noted.

## Results

| Test   | Comment |fullOptJS (0.6.X)| fullOptJS (1.0.0-M3)|
|------- |-----------|-----:|----:|
| test0 | no main (despite comment above) | 9,255 | 8,838 |
| test1  | no code except main | 9,485 | 9,025 |
| test2  | a single native trait | 9,486 | 9,025|
| test3  | non-native traits, with new | 9,486 | 9,025|
| test4  | println of some strings with s/f | 44,423 | 38,641 |
| test5  | Immutable HashMap only | 42,988 | 40,539 |
| test6 | Immutable HashMap and printf | 65,365 | 58,689 |
| test7 | Immutable HashMap, Seq | 88,837 | 81,205 |
| test8 | Immutable HashMap, Seq, HashSet | 97,165 | 89,303|
| test9 | Create js array, literals, js.Dicts | 9,493 | 9,031 |
| test10 | 2 case class, no main (1 case class is the same size!) | 9,256 ?? | 8,839 |
| test11 | js Promise+scala future (just Promise) | 66,033 (9,514) | 66,034 (9,514) |

Notes:
* println adds a lot of kb.
* Each immutable structure seems to add around 10-20K.
* Zipped sizes are small. test0 => 3,625 (3,480), test8 => 23,459 (21,950).

It's pretty clear, and validates our expectations, that the scala.js overhead is
really due to the parts that can get pulled in rather than scala.js itself. If
you use existing scala.js libraries, then you most likely pull in alot of the
overhead parts of the standard scala library.

Using futures, println, immutable data structures appears to add around ~150kb
(eyeball) to the fullOptJS module size.

## Sizes of JS Related Libraries

Some of these have dependencies that are not reflected directly in their byte
count but some do! Some sizes were checked via npm installing and some via cdn.

| JS Library | Comment | size (min or non-min) |
|-------------|---------|--------|
| ramda | functional lib| 44,743 |
| immutable-js | immutable data structures | 56,904 |
| monet | some monads | 27,665 (non-min) |
| sprintf   | printf-like | 13,565 |
| office-fabric-ui-react | UI component | 801,429 |

If you add most of a UI component library, the scala.js overhead is a small % of
the total bundle size. Most effort should be put into reducing the bundling of
un-needed UI components.

Altogether, non-UI, minimized code size is around ~140kb (eyeball) for
equivalent parts in scala so *if* you include those parts, its about the same
overall. non-scala.js code allows you to more cleverly carve up your kb
budget. Also, if you have a mixed project, it's additive.
