import           Lib
import           Test.QuickCheck

propReplicatedLength :: NonNegative Int -> Char -> Bool
propReplicatedLength (NonNegative n) x =
  length' (replicate' n x) == n

main :: IO ()
main = quickCheck propReplicatedLength
