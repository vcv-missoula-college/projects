import re
import subprocess

# Check that PEP8 standard is maintained
pep8check = False
try:
    results = subprocess.check_output(['pycodestyle', 'hello.py'])
    if len(results) == 0:
        pep8check = True
except Exception as e:
    print("PEP8 failed", e)

# Test Functionality
test_score = 0
total_tests = 1
try:
    results = subprocess.check_output(["python", "hello.py"])
    match = re.search('hello\\s*world', results.decode("utf-8"), re.IGNORECASE)
    if match is not None:
        test_score += 1  # Test Passed
except Exception as e:
    print("test failed: ", e)
    pass  # test failed

print("Test-Results: ")
print("PEP8 conformance: {}.".format("Passed" if pep8check else "failed"))
print("Functionals tests passed {} out of {} tests.".format(test_score,
      total_tests))
