## MVI Sample

Learn MVI from sample

### What is MVI
MVI stands for Model-View-Intent pattern, which is a one-way event flow driver.
- Model represents a state.
- View in MVI as view in MVP, represents interfaces which are implemented by Fragment or Activity.
- Intent represents an intention to perform an action. For every action, a View receives an intent, the Presenter observes Intent, and
models translate it into a new State.