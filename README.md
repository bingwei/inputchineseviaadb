inputchineseviaadb
==================

Input unicode text via adb and then convert to Chinese characters

    1. It needs to install "Input Unicode" apk first.
    2. And then use this apk to convert unicode to encoded characters
    3. finally, the encoded characters will be saved in clipboard

= Usage

```python
>>> import os
>>> os.chdir("pyscript")
>>> import utils
>>> test_text = u"test: eng 123 黑色"
>>> utils.get_encoded_character(test_text)
```
= Example

`python pyscript/testScript.py`
