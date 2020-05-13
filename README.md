# StockMarketSimulator
This project is a simulation of a trade market using design patterns

4 Pattern used:
Template-- this is used to describe a sequence in which the project works. First generate data then do the trading then create the report then interact with the user
Obeserver-- this comes into play when a share has been sold. It updates the companies stock.
when a share is bought it is used to update invesotrs details in the market.
Proxy-- this is used to check if an investor can buy shares or a company can sell shares. This also removes company and investors from the list if they are no longer able to trade, budget 0 or number of shares get 0.
Builder-- this is used to create objects of 100 companies and 100 investors.
