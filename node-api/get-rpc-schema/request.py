import json
import os

import pycspr



# A known casper test-net node address.
_NODE_ADDRESS: str = os.getenv("CASPER_NODE_ADDRESS", "3.136.227.9")


def main():
    """Retrieve node JSON-RPC schema information.
    
    """
    # Set client.
    client = pycspr.NodeClient(pycspr.NodeConnection(host=_NODE_ADDRESS))

    # Get RPC schema.
    schema: dict = client.get_rpc_schema()
    
    print("-----------------------------------------------------------------------------------------------------")
    print(f"QUERIED TEST-NET NODE {_NODE_ADDRESS}")
    print("-----------------------------------------------------------------------------------------------------")
    print(f"{json.dumps(schema, indent=4)}")
    print("-----------------------------------------------------------------------------------------------------")


if __name__ == "__main__":
    try:
        main()
    except Exception as err:
        print(f"API ERROR @ NODE {_NODE_ADDRESS} :: {err}")
